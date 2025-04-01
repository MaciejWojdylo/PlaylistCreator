package com.example.spotifyapp;


import com.example.spotifyapp.playlist.application.PlaylistService;
import com.example.spotifyapp.playlist.domain.Playlist;
import com.example.spotifyapp.playlist.domain.PlaylistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaylistServiceTest {

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistService playlistService;

    private Playlist playlist;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playlist = Playlist.createPlaylistObject();
        playlist.setId(1L);
        playlist.setName("Test Playlist");
    }

    @Test
    void testFindById_Success() {
        when(playlistRepository.findById(1L)).thenReturn(Optional.of(playlist));

        Optional<Playlist> result = playlistService.getPlaylistById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Playlist",result.get().getName());
    }

    @Test
    void testFindById_NotFound() {
        when(playlistRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Playlist> result = playlistService.getPlaylistById(1L);

        assertFalse(result.isPresent());
    }

    @Test
    void testCreatePlaylist() {
        when(playlistRepository.save(any(Playlist.class))).thenReturn(playlist);

        String name = "Test Playlist";
        Playlist result = playlistService.createPlaylist(name);

        assertNotNull(result);
        assertEquals("Test Playlist", result.getName());
        verify(playlistRepository, times(1)).save(any(Playlist.class));
    }
}
