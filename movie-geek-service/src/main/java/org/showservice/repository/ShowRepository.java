package org.showservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.showservice.models.Show;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    //Change array size in the LIMIT after need.
    @Query(value = "SELECT * FROM shows ORDER BY imdb_score DESC LIMIT 200", nativeQuery = true)
    List<Show> findBestRatedShows();

    @Query(value = "SELECT * FROM shows ORDER BY trend_score DESC LIMIT 200", nativeQuery = true)
    List<Show> findMostTrending();

    @Query(value = "SELECT * FROM shows WHERE LOWER(genre) = LOWER(:genre)", nativeQuery = true)
    List<Show> findShowsByGenre(@Param("genre") String genre);

    @Query(value = "SELECT * FROM shows WHERE LOWER(genre) = LOWER(:genre) ORDER BY trend_score DESC LIMIT 200", nativeQuery = true)
    List<Show> findTrendingShowsByGenre(@Param("genre") String genre);


}

