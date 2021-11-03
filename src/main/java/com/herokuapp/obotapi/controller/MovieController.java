package com.herokuapp.obotapi.controller;

import com.herokuapp.obotapi.dto.MovieDto;
import com.herokuapp.obotapi.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MovieController {

    private static Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/movie", consumes = "Application/json")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto){
        try {
            MovieDto returnDto = movieService.createMovie(movieDto);
            LOG.info("Movie Created: {}", returnDto.getId());
            return new ResponseEntity<>(returnDto, HttpStatus.CREATED);
        } catch (Exception exception){
            LOG.error("Error processing {}.  {}", movieDto, exception.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping(path = "/movie")
    public List<MovieDto> getMovies(){
        try {
            List<MovieDto> allMovies = movieService.getMovies();
            LOG.info("All movies returned.");
            return allMovies;
        } catch (Exception exception) {
            LOG.error("Error processing GET method: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
