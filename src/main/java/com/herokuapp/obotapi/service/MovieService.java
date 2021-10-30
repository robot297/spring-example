package com.herokuapp.obotapi.service;

import com.herokuapp.obotapi.dto.MovieDto;

public interface MovieService {

    MovieDto createMovie(MovieDto movieDto) throws Exception;
}
