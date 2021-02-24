package com.simbirsoft.practice.service;

import com.simbirsoft.practice.controller.dto.SingerRequest;
import com.simbirsoft.practice.controller.dto.SingerResponse;
import com.simbirsoft.practice.entity.Singer;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface SingerService {

    SingerResponse findById(long id) throws EntityNotFoundException;

    SingerResponse save(SingerRequest singerRequest);

    Long deleteById(long id) throws EntityNotFoundException;

    SingerResponse update(SingerRequest singerRequest, long id) throws EntityNotFoundException;

    Singer findSingerById(long id) throws EntityNotFoundException;
}
