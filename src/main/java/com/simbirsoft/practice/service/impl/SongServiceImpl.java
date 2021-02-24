package com.simbirsoft.practice.service.impl;

import com.simbirsoft.practice.controller.dto.SongRequest;
import com.simbirsoft.practice.controller.dto.SongResponse;
import com.simbirsoft.practice.entity.Song;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import com.simbirsoft.practice.repository.SongRepository;
import com.simbirsoft.practice.service.SingerService;
import com.simbirsoft.practice.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class SongServiceImpl implements SongService {

    private final String ENTITY_NAME_SONG = "SONG";

    private SongRepository songRepository;

    private SongResponse songResponse = new SongResponse();

    private final SingerService singerService;

    public SongServiceImpl(SongRepository songRepository,
                           SingerService singerService) {
        this.songRepository = songRepository;
        this.singerService = singerService;
    }

    @Override
    public SongResponse findById(long id) throws EntityNotFoundException {
        chekSongById(id);
        SongResponse innerSongResponse = songResponse
                .fromSongToSongResponse(songRepository.findById(id));
        log.info("IN SongRepositoryImpl_findById - {} {} successfully", id, innerSongResponse);
        return innerSongResponse;
    }

    @Override
    public SongResponse save(SongRequest songRequest) throws EntityNotFoundException {
        SongResponse innerSongResponse = songResponse
                .fromSongToSongResponse(songRepository.save(
                        songRequest.fromSongRequestToSong(
                                songRequest,
                                singerService)));
        log.info("IN SongServiceImpl_save - {} successfully", innerSongResponse);
        return innerSongResponse;
    }

    @Override
    public Long deleteById(long id) throws EntityNotFoundException {
        chekSongById(id);
        songRepository.deleteById(id);
        log.info("IN SongServiceImpl_deleteById - {} successfully", id);
        return id;
    }

    @Override
    public SongResponse update(SongRequest songRequest, long id) throws EntityNotFoundException {
        chekSongById(id);
        Song innerSong = songRepository.findById(id);
        innerSong.setNameOfTheSong(songRequest.getNameOfTheSong());
        innerSong.setPublicationDate(songRequest.getPublicationDate());
        innerSong.setSinger(singerService.findSingerById(songRequest.getSingerId()));
        SongResponse innerSongResponse = songResponse.fromSongToSongResponse(innerSong);
        log.info("IN SongServiceImpl_update - {} {} successfully", id, innerSongResponse);
        return innerSongResponse;
    }

    @Override
    public Song findSongById(long id) throws EntityNotFoundException {
        chekSongById(id);
        Song innerSong = songRepository.findById(id);
        log.info("IN SongServiceImpl_findSongById - {} successfully", innerSong);
        return innerSong;
    }

    private void chekSongById(long id) throws EntityNotFoundException {
        if (songRepository.findById(id) == null) {
            throw new EntityNotFoundException(ENTITY_NAME_SONG);
        }
    }
}
