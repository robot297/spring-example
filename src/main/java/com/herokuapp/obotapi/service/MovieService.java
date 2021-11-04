package com.herokuapp.obotapi.service;

import com.herokuapp.obotapi.dto.MovieDto;
import com.herokuapp.obotapi.exceptions.MovieExistsException;

import java.util.List;

public interface MovieService {

    MovieDto createMovie(MovieDto movieDto) throws MovieExistsException;

    List<MovieDto> getMovies() throws Exception;
}
