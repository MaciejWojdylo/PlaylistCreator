package com.example.spotifyapp.controller;


import com.example.spotifyapp.service.PlaylistHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class PlaylistMakerController {

    private final PlaylistHistoryService playlistHistoryService;

    public PlaylistMakerController(PlaylistHistoryService playlistHistoryService) {
        this.playlistHistoryService = playlistHistoryService;
    }

    @PostMapping("/playlist-maker/save")
    public ResponseEntity<String> savePlaylist(
            @RequestBody List<String> playlistWords,
            @AuthenticationPrincipal UserDetails userDetails) {

        String username = userDetails.getUsername();
        playlistHistoryService.savePlaylistForUser(username, playlistWords);
        return ResponseEntity.ok("Playlista została zapisana!");
    }

    @GetMapping("/playlist-maker")
    public String showPlaylistMaker(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "playlist-maker";
    }

    @PostMapping("/playlist-maker")
    public String processTextInput(@RequestParam String inputText, Model model) {
        String[] words = inputText.split("\\s+");
        model.addAttribute("playlist", words);
        return "playlist-maker";
    }
}


