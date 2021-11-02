package com.herokuapp.obotapi.service;

import com.herokuapp.obotapi.dao.Movie;
import com.herokuapp.obotapi.dto.MovieDto;
import com.herokuapp.obotapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    /**
     *     The service will pass data from our DTO's to our Models (or DAOs).  The MovieRepository interface that is
     *     autowired is where we actually right data to the database.
    */

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDto createMovie(MovieDto movieDto){
        Movie movie = new Movie();

        movie.setMovieName(movieDto.getMovieName());
        movie.setRating(movieDto.getRating());

        // This saves the movie to the database
        Movie savedMovie = movieRepository.save(movie);

        movieDto.setId(savedMovie.getId());

        return movieDto;
    }

    @Override
    public List<MovieDto> getMovies(){
        List<Movie> allMovies = movieRepository.findAll();

        List<MovieDto> movieDtoList = new ArrayList<>();

        for(Movie movie: allMovies){
            MovieDto movieDto = new MovieDto(movie.getId(), movie.getMovieName(), movie.getRating());

            movieDtoList.add(movieDto);
        }

        return movieDtoList;
    }
}
