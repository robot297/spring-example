package com.herokuapp.obotapi.repository;

import com.herokuapp.obotapi.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //This will find a movie in the repository by movie name.
    Movie findMovieByMovieName(String movieName);

    // This will find a movie by its unique id.
    Movie findMovieById(Long movieID);
}
