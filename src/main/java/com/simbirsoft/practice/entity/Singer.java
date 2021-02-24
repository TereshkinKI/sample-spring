package com.simbirsoft.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "singer")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "singer")
    private String singerName;

    @OneToMany(mappedBy = "singer")
    private List<Song> song;
}
