package com.example.spotifyapp.controller;

import com.example.spotifyapp.service.PlaylistHistoryService;
import com.example.spotifyapp.model.PlaylistHistory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlaylistHistoryController {

    private final PlaylistHistoryService playlistHistoryService;

    public PlaylistHistoryController(PlaylistHistoryService playlistHistoryService) {
        this.playlistHistoryService = playlistHistoryService;
    }

    @GetMapping("/history")
    public String showPlaylistHistory(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        List<PlaylistHistory> playlists = playlistHistoryService.getPlaylistsByUser(username);

        if (playlists.isEmpty()) {
            model.addAttribute("message", "Nie masz zapisanych playlist.");
        } else {
            model.addAttribute("playlists", playlists);
        }

        return "playlist-history";
    }
}
