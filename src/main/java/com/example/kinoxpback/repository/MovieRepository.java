package com.example.kinoxpback.repository;

import com.example.kinoxpback.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String>{
}