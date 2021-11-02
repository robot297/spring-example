package com.herokuapp.obotapi.service;

import com.herokuapp.obotapi.dto.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto createMovie(MovieDto movieDto) throws Exception;

    List<MovieDto> getMovies() throws Exception;
}
