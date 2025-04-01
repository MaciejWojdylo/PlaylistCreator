package com.example.spotifyapp.playlist.infrastructure.dto;

import com.example.spotifyapp.playlist.domain.Playlist;
import lombok.Getter;

import java.util.List;

@Getter
public class PlaylistsResponse {

    private final List<PlaylistResponse> playlists;

    public PlaylistsResponse(List<Playlist> playlists) {
        this.playlists = playlists.stream()
                .map(PlaylistResponse::new)
                .toList();
    }

}