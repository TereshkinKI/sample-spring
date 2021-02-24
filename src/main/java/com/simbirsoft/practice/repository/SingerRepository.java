package com.simbirsoft.practice.repository;

import com.simbirsoft.practice.entity.Singer;
import com.simbirsoft.practice.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
    Singer findById(long id);
}
