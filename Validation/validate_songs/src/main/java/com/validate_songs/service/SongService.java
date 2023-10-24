package com.validate_songs.service;

import com.validate_songs.model.Song;
import com.validate_songs.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public void addNewSong(Song song) {
        songRepository.save(song);
    }
}
