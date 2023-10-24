package com.validate_songs.service;

import com.validate_songs.model.Genre;

import java.util.List;

public interface IGenreService {
    List<Genre> findAllGenre();
}
