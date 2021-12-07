package com.herokuapp.obotapi.controller;

import com.herokuapp.obotapi.dto.MovieDto;
import com.herokuapp.obotapi.exceptions.MovieExistsException;
import com.herokuapp.obotapi.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@Api(tags = "Movie REST endpoint.", value = "MovieController")
public class MovieController {

    private static final Logger LOG = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @ApiOperation(value = "Creates a new movie record.")
    @PostMapping(path = "/movie", consumes = "Application/json")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto){
        try {
            MovieDto returnDto = movieService.createMovie(movieDto);
            LOG.info("Movie Created: {}", returnDto.getMovieName());
            return new ResponseEntity<>(returnDto, HttpStatus.CREATED);
        } catch (MovieExistsException exception){
            LOG.warn("Error processing {}.  {}", movieDto.getMovieName(), exception.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @ApiOperation(value = "Gets all the movies in the database.")
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

    @ApiOperation(value = "Updates a single movie in the database.")
    @PutMapping(path = "/movie")
    public ResponseEntity<MovieDto> updateMovie(@Valid @RequestBody MovieDto movieDto){
        try {
            MovieDto returnDto = movieService.updateMovie(movieDto);
            return new ResponseEntity<>(returnDto, HttpStatus.ACCEPTED);
        } catch (Exception exception){
            LOG.error("Error processing POST method: {}", exception.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}
