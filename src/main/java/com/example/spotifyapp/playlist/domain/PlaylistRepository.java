package com.example.spotifyapp.playlist.domain;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository {
    List<Playlist> findAll();
    Playlist save(Playlist playlist);
    Optional<Playlist> findById(Long id);
}
