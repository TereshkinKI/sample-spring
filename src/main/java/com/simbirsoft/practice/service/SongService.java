package com.simbirsoft.practice.service;

import com.simbirsoft.practice.controller.dto.SongRequest;
import com.simbirsoft.practice.controller.dto.SongResponse;
import com.simbirsoft.practice.entity.Song;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface SongService {

    SongResponse findById(long id) throws EntityNotFoundException;

    SongResponse save(SongRequest songRequest) throws EntityNotFoundException;

    Long deleteById(long id) throws EntityNotFoundException;

    SongResponse update(SongRequest songRequest, long id) throws EntityNotFoundException;

    Song findSongById(long id) throws EntityNotFoundException;
}
