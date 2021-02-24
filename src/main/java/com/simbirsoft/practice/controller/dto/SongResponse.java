package com.simbirsoft.practice.controller.dto;

import com.simbirsoft.practice.entity.Song;
import lombok.Data;

import java.util.Date;

@Data
public class SongResponse {

    private String nameOfTheSong;
    private Date publicationDate;
    private long singerId;

    public SongResponse fromSongToSongResponse(Song song) {
        if (song != null) {
            this.nameOfTheSong = song.getNameOfTheSong();
            this.publicationDate = song.getPublicationDate();
            this.singerId = song.getSinger().getId();
        }
        return this;
    }
}
