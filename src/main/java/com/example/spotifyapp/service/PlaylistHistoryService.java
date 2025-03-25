package com.example.spotifyapp.service;

import com.example.spotifyapp.model.PlaylistHistory;
import com.example.spotifyapp.model.User;
import com.example.spotifyapp.repository.PlaylistHistoryRepository;
import com.example.spotifyapp.repository.UserRepository;
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

    public void savePlaylistForUser(String username, List<String> playlistWords) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Użytkownik nie znaleziony");
        }

        PlaylistHistory playlistHistory = new PlaylistHistory();
        playlistHistory.setWords(playlistWords);
        playlistHistory.setTimestamp(LocalDateTime.now());
        playlistHistory.setUser(user);

        playlistHistoryRepository.save(playlistHistory);
    }
}


