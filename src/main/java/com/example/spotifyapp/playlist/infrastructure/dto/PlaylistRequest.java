package com.example.spotifyapp.playlist.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlaylistRequest {

    private String name;

    public PlaylistRequest(String name) {
        this.name = name;
    }

}

