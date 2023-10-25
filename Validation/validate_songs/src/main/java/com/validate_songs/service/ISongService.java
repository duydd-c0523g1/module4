package com.validate_songs.service;

import com.validate_songs.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    void addNewSong(Song song);
    Page<Song> findAllSong(Pageable pageable);
}
