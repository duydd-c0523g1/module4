package com.validate_songs.repository;

import com.validate_songs.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findAll();
}
