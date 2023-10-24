package com.validate_songs.service;

import com.validate_songs.model.Genre;
import com.validate_songs.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    @Autowired
    private IGenreRepository genreRepository;

    @Override
    public List<Genre> findAllGenre() {
        return genreRepository.findAll();
    }
}
