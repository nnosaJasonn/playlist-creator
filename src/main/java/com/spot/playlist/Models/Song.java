package com.spot.playlist.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private long Id;
    @Column(nullable = false)
    private String Title;
    @ManyToMany(mappedBy = "songs")
    @JsonBackReference(value="artist-song")
    @JsonIgnore
    private List<Artist> artists;
    @Column
    private long durationInSeconds;
    @ManyToOne
    @JsonBackReference("album-song")
    @JsonIgnore
    private Album album;


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

    public void setTitle(String title)
    {
        Title = title;
    }

    public long getDurationInSeconds()
    {
        return durationInSeconds;
    }

    public void setDurationInSeconds(long durationInSeconds)
    {
        this.durationInSeconds = durationInSeconds;
    }
}
