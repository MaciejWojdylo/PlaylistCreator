package com.example.spotifyapp.playlist.application;


import com.example.spotifyapp.playlist.domain.Playlist;
import com.example.spotifyapp.playlist.domain.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(String name) {
        Playlist playlist = new Playlist(name);
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }
}

