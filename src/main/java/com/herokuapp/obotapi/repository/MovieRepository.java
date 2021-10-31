package com.herokuapp.obotapi.repository;

import com.herokuapp.obotapi.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // For now this is empty until we add queries for the database
}
