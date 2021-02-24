package com.simbirsoft.practice.repository;

import com.simbirsoft.practice.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Song findById(long id);
}
