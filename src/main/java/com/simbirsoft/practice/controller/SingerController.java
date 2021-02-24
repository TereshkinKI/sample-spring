package com.simbirsoft.practice.controller;

import com.simbirsoft.practice.controller.dto.SingerRequest;
import com.simbirsoft.practice.controller.dto.SingerResponse;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import com.simbirsoft.practice.service.SingerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/singer")
public class SingerController {

    private final SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    @PostMapping
    public SingerResponse saveSinger(@RequestBody @Valid SingerRequest singerRequest) {
        return singerService.save(singerRequest);
    }

    @GetMapping("/{id}")
    public SingerResponse findSingerById(@PathVariable("id") long id) throws EntityNotFoundException {
        return singerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long deleteSingerById(@PathVariable("id") long id) throws EntityNotFoundException {
        return singerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public SingerResponse updateSinger(@RequestBody @Valid SingerRequest singerRequest,
                                       @PathVariable("id") long id) throws EntityNotFoundException {
        return singerService.update(singerRequest, id);
    }
}
