package com.example.spotifyapp.playlist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static  Playlist createPlaylistObject(){
        return new Playlist();
    }

    protected Playlist() {}

    public Playlist(String name) {
        this.name = name;
    }
}
