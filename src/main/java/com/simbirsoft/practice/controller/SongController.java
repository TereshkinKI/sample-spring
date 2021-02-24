package com.simbirsoft.practice.controller;

import com.simbirsoft.practice.controller.dto.SongRequest;
import com.simbirsoft.practice.controller.dto.SongResponse;
import com.simbirsoft.practice.exception.EntityNotFoundException;
import com.simbirsoft.practice.service.SongService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public SongResponse saveSong(@RequestBody @Valid SongRequest songRequest) throws EntityNotFoundException {
        return songService.save(songRequest);
    }

    @GetMapping("/{id}")
    public SongResponse findSongById(@PathVariable("id") long id) throws EntityNotFoundException {
        return songService.findById(id);
    }

    @PutMapping("/{id}")
    public SongResponse updateSong(@RequestBody @Valid SongRequest songRequest,
                                   @PathVariable("id") long id) throws EntityNotFoundException {
        return songService.update(songRequest, id);
    }

    @DeleteMapping("/{id}")
    public Long deleteSong(@PathVariable("id") long id) throws EntityNotFoundException {
        return songService.deleteById(id);
    }

}
