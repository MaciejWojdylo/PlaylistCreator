package com.example.spotifyapp;

import com.example.spotifyapp.playlist.application.PlaylistService;
import com.example.spotifyapp.playlist.domain.Playlist;
import com.example.spotifyapp.playlist.infrastructure.dto.PlaylistRequest;
import com.example.spotifyapp.playlist.exception.PlaylistNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.spotifyapp.playlist.infrastructure.PlaylistController;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class PlaylistControllerTest {

    @Mock
    private PlaylistService playlistService;

    @InjectMocks
    private PlaylistController playlistController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playlistController).build();
    }

    @Test
    void createPlaylist() throws Exception {
        PlaylistRequest request = new PlaylistRequest("New Playlist");
        Playlist playlist = new Playlist("New Playlist");
        when(playlistService.createPlaylist("New Playlist")).thenReturn(playlist);
        mockMvc.perform(post("/api/playlists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"New Playlist\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(playlist.getId()))
                .andExpect(jsonPath("$.name").value(playlist.getName()));
    }

    @Test
    void getPlaylistById() throws Exception {
        Long id = 1L;
        Playlist playlist = new Playlist("Test Playlist");
        when(playlistService.getPlaylistById(id)).thenReturn(Optional.of(playlist));
        mockMvc.perform(get("/api/playlists/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(playlist.getId()))
                .andExpect(jsonPath("$.name").value(playlist.getName()));
    }
    @Test
    void getPlaylistById_NotFound() throws Exception {
        Long id = 1L;
        when(playlistService.getPlaylistById(id)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/playlists/{id}", id))
                .andExpect(status().isNotFound());
    }
    @Test
    void getAllPlaylists() throws Exception {
        List<Playlist> playlists = List.of(new Playlist("Test Playlist 1"), new Playlist("Test Playlist 2"));
        when(playlistService.getAllPlaylists()).thenReturn(playlists);
        mockMvc.perform(get("/api/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.playlists[0].name").value(playlists.get(0).getName()))
                .andExpect(jsonPath("$.playlists[1].name").value(playlists.get(1).getName()));
    }

    @Test
    void handlePlaylistNotFoundException() throws Exception {
        Long id = 999L;
        when(playlistService.getPlaylistById(id)).thenThrow(new PlaylistNotFoundException(id));
        mockMvc.perform(get("/api/playlists/{id}", id))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Playlist with id " + id + " not found"));
    }
}
