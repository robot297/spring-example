package com.herokuapp.obotapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.obotapi.dto.MovieDto;
import com.herokuapp.obotapi.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    private final String url = "/movie";

    @Test
    public void postMovieTest() throws Exception {
        Long id = 1L;
        String movieName = "Test_Movie";
        int rating = 5;

        MovieDto movieDto = new MovieDto(id, movieName, rating);

        ObjectMapper objectMapper = new ObjectMapper();

        String movieAsString = objectMapper.writeValueAsString(movieDto);

        when(movieService.createMovie(any(MovieDto.class))).thenReturn(movieDto);

        mockMvc.perform(post(url)
                .content(movieAsString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.movieName").value(movieName))
                .andExpect(jsonPath("$.rating").value(rating));
    }
}
