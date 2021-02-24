package com.simbirsoft.practice.service.impl;

import com.simbirsoft.practice.controller.dto.SingerRequest;
import com.simbirsoft.practice.controller.dto.SingerResponse;
import com.simbirsoft.practice.entity.Singer;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import com.simbirsoft.practice.repository.SingerRepository;
import com.simbirsoft.practice.service.SingerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class SingerServiceImpl implements SingerService {

    private final String ENTITY_NAME_SINGER = "SINGER";

    private final SingerRepository singerRepository;
    private final SingerResponse singerResponse = new SingerResponse();

    public SingerServiceImpl(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    public SingerResponse findById(long id) throws EntityNotFoundException {
        chekSingerById(id);
        SingerResponse innerSingerResponse = singerResponse
                .fromSingerToSingerResponse(singerRepository.findById(id));
        log.info("IN SingerServiceImpl_findById - {} {} successfully", id, innerSingerResponse);
        return innerSingerResponse;
    }

    @Override
    public SingerResponse save(SingerRequest singerRequest) {
        SingerResponse innerSingerResponse = singerResponse
                .fromSingerToSingerResponse(singerRepository
                .save(singerRequest.fromSingerRequestToSinger(singerRequest)));
        log.info("IN SingerServiceImpl_save - {} successfully", innerSingerResponse);
        return innerSingerResponse;
    }

    @Override
    public Long deleteById(long id) throws EntityNotFoundException {
        chekSingerById(id);
        singerRepository.deleteById(id);
        log.info("IN SingerServiceImpl_deleteById - {} successfully", id);
        return id;
    }

    @Override
    public SingerResponse update(SingerRequest singerRequest, long id) throws EntityNotFoundException {
        chekSingerById(id);
        Singer innerSinger = singerRepository.findById(id);
        innerSinger.setSingerName(singerRequest.getSingerName());
        singerRepository.save(innerSinger);
        SingerResponse innerSingerResponse = singerResponse
                .fromSingerToSingerResponse(innerSinger);
        log.info("IN SingerServiceImpl_update - {} {} successfully", id, innerSingerResponse);
        return innerSingerResponse;
    }

    @Override
    public Singer findSingerById(long id) throws EntityNotFoundException {
        chekSingerById(id);
        Singer innerSinger = singerRepository.findById(id);
        log.info("IN SingerServiceImpl_findSingerById - {} successfully", innerSinger);
        return innerSinger;
    }


    private void chekSingerById(long id) throws EntityNotFoundException {
        if (singerRepository.findById(id) == null) {
            throw new EntityNotFoundException(ENTITY_NAME_SINGER);
        }
    }
}
