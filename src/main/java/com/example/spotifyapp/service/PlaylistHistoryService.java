package com.example.spotifyapp.service;

import com.example.spotifyapp.model.PlaylistHistory;
import com.example.spotifyapp.model.Song;
import com.example.spotifyapp.model.User;
import com.example.spotifyapp.repository.PlaylistHistoryRepository;
import com.example.spotifyapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlaylistHistoryService {

    private final PlaylistHistoryRepository playlistHistoryRepository;
    private final UserRepository userRepository;

    public PlaylistHistoryService(PlaylistHistoryRepository playlistHistoryRepository, UserRepository userRepository) {
        this.playlistHistoryRepository = playlistHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void savePlaylistForUser(String username, List<Song> songs) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        PlaylistHistory playlistHistory = new PlaylistHistory();
        playlistHistory.setSongs(songs);
        playlistHistory.setTimestamp(LocalDateTime.now());
        playlistHistory.setUser(user);

        playlistHistoryRepository.save(playlistHistory);
    }

    public List<PlaylistHistory> getPlaylistsByUser(String username) {
        return playlistHistoryRepository.findByUser_Username(username);
    }
}
