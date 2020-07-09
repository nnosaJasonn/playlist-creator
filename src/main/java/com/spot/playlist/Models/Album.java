package com.spot.playlist.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private long Id;
    @Column
    private String Genre;
    @Column
    private String Title;

    @ManyToMany(mappedBy = "albums")
    @JsonBackReference(value="artist-album")
    private List<Artist> artist;

    @OneToMany(mappedBy = "album")
    @JsonManagedReference (value="album-song")
    @JsonIgnore
    private List<Song> songs;

    public long getId()
    {
        return Id;
    }

    public void setId(long id)
    {
        Id = id;
    }

    public String getTitle()
    {
        return Title;
    }





}
