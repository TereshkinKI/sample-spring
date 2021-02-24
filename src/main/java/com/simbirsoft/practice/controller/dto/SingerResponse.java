package com.simbirsoft.practice.controller.dto;

import com.simbirsoft.practice.entity.Singer;
import lombok.Data;

@Data
public class SingerResponse {

    private long id;
    private String singerName;

    public SingerResponse fromSingerToSingerResponse(Singer singer) {
        if (singer != null) {
            this.id = singer.getId();
            this.singerName = singer.getSingerName();
        }
        return this;
    }
}
