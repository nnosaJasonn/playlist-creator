package com.spot.playlist.Repositories;

import com.spot.playlist.Models.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository <Artist, Long>
{

}
