package com.spot.playlist.Controllers;

import com.spot.playlist.Models.Artist;
import com.spot.playlist.Repositories.ArtistRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArtistController
{
    private final ArtistRepository artistDao;

    public ArtistController(ArtistRepository artistDao)
    {
        this.artistDao = artistDao;
    }

    @GetMapping("/artist.json")
    public @ResponseBody
    Iterable<Artist> viewArtistsJSON()
    {
        return artistDao.findAll();
    }

    @PostMapping("/postArtist")
    public @ResponseBody
    List<Artist> postArtist(@RequestBody List<Artist> artists)
    {
        if (artists.size() > 0)
        {
            System.out.println(artists);
        }
        try
        {
            artistDao.saveAll(artists);
        } catch (Exception error)
        {
            System.out.println(error.getMessage());
        }
        return artists;
    }
}
