package com.herokuapp.obotapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MovieDto {

    private Long id;

    @NotEmpty(message = "movieName is a required field.")
    @Size(max = 50, message = "movieName cannot contain more than 50 characters")
    private String movieName;

    @Size(min = 0, max = 5, message = "rating has to be between 0 - 5.")
    private int rating;

    public MovieDto() {
    }

    public MovieDto(Long id, String movieName, int rating) {
        this.id = id;
        this.movieName = movieName;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
