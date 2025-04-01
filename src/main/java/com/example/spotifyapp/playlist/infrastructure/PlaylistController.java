package com.example.spotifyapp.playlist.infrastructure;

import com.example.spotifyapp.playlist.application.PlaylistService;
import com.example.spotifyapp.playlist.domain.Playlist;
import com.example.spotifyapp.playlist.infrastructure.dto.PlaylistsResponse;
import com.example.spotifyapp.playlist.infrastructure.dto.PlaylistRequest;
import com.example.spotifyapp.playlist.infrastructure.dto.PlaylistResponse;
import com.example.spotifyapp.playlist.exception.PlaylistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<PlaylistResponse> createPlaylist(@RequestBody PlaylistRequest request) {
        Playlist playlist = playlistService.createPlaylist(request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new PlaylistResponse(playlist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponse> getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id)
                .map(playlist -> ResponseEntity.ok(new PlaylistResponse(playlist)))
                .orElseThrow(() -> new PlaylistNotFoundException(id));
    }

    @GetMapping
    public ResponseEntity<PlaylistsResponse> getAllPlaylists() {
        List<Playlist> playlists = playlistService.getAllPlaylists();
        return ResponseEntity.ok(new PlaylistsResponse(playlists));
    }

    @ExceptionHandler(PlaylistNotFoundException.class)
    public ResponseEntity<String> handlePlaylistNotFound(PlaylistNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
