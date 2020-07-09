package com.spot.playlist.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private long Id;
    @Column(nullable = false)
    private String Name;
    @Column
    private String img;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "artists_albums",
            joinColumns = {@JoinColumn(name = "artist_id")},
            inverseJoinColumns = {@JoinColumn(name = "album_id")}
    )
    private List<Album> albums;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "artists_songs",
            joinColumns = {@JoinColumn(name = "artist_id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id")}
    )
    private List<Song> songs;
    @Column
    private String Genre;

    public Artist()
    {
    }

    public Artist(long id, String name, String img, String genre)
    {
        Id = id;
        Name = name;
        this.img = img;
        Genre = genre;
    }

    public Artist(long id, String name, String img, List<Album> albums, List<Song> songs, String genre)
    {
        Id = id;
        Name = name;
        this.img = img;
        this.albums = albums;
        this.songs = songs;
        Genre = genre;
    }

    public long getId()
    {
        return Id;
    }

    public void setId(long id)
    {
        Id = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }


    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public List<Album> getAlbums()
    {
        return albums;
    }

    public void setAlbums(List<Album> albums)
    {
        this.albums = albums;
    }

    public List<Song> getSongs()
    {
        return songs;
    }

    public void setSongs(List<Song> songs)
    {
        this.songs = songs;
    }

    public String getGenre()
    {
        return Genre;
    }

    public void setGenre(String genre)
    {
        Genre = genre;
    }
}