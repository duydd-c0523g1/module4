package com.validate_songs.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class SongDTO {
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,800}$",message = "Cannot include special characters")
    private String songName;
    private Set<Genre> genres;
    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,300}$",message = "Cannot include special characters")
    private String artist;

    public SongDTO() {
    }

    public SongDTO(String songName, Set<Genre> genres, String artist) {
        this.songName = songName;
        this.genres = genres;
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
