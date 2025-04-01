package com.example.spotifyapp.playlist.infrastructure.dto;

import com.example.spotifyapp.playlist.domain.Playlist;
import lombok.Getter;

@Getter
public class PlaylistResponse {

    private final Long id;
    private final String name;

    public PlaylistResponse(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
    }

}