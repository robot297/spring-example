package com.herokuapp.obotapi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Max;

@ApiModel("This model is used to create the movie record.")
public class MovieDto {

    @ApiModelProperty(notes = "Auto generated with a unique ID.", required = true, position = 1, hidden = true)
    private Long id;

    @ApiModelProperty(notes = "movieName should not be empty or null", example = "Star Wars", required = true, position = 2)
    @NotEmpty(message = "movieName is a required field.")
    private String movieName;

    @ApiModelProperty(notes = "rating should be between 0 and 5.", position = 3)
    @Min(value = 0, message = "rating has to be between 0 - 5.")
    @Max(value = 5, message = "rating has to be between 0 - 5.")
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
