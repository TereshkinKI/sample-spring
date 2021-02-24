package com.simbirsoft.practice.controller.dto;

import com.simbirsoft.practice.entity.Singer;
import lombok.Data;

@Data
public class SingerRequest {

    private String singerName;

    public Singer fromSingerRequestToSinger(SingerRequest singerRequest) {
        Singer singer = new Singer();
        singer.setSingerName(singerRequest.getSingerName());
        return singer;
    }
}
