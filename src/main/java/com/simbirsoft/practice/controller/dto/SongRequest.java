package com.simbirsoft.practice.controller.dto;

import com.simbirsoft.practice.entity.Song;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import com.simbirsoft.practice.service.SingerService;
import lombok.Data;

import java.util.Date;

@Data
public class SongRequest {

    private String nameOfTheSong;
    private long singerId;
    private Date publicationDate;

    public Song fromSongRequestToSong(SongRequest songRequest,
                                      SingerService singerService) throws EntityNotFoundException {
        Song song = new Song();
        song.setNameOfTheSong(songRequest.getNameOfTheSong());
        song.setPublicationDate(song.getPublicationDate());
        song.setSinger(singerService.findSingerById(songRequest.getSingerId()));
        return song;
    }
}
