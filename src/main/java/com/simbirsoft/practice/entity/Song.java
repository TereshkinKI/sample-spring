package com.simbirsoft.practice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@Table(name = "song")
public class Song{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_of_the_song")
    private String nameOfTheSong;

    @Column(name = "publication_date")
    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;
}
