package com.validate_songs.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;
    private String genreName;
    @ManyToMany(mappedBy = "genres")
    Set<Song> songs;

    public Genre() {
    }

    public Genre(Integer genreId, String genreName, Set<Song> songs) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.songs = songs;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
