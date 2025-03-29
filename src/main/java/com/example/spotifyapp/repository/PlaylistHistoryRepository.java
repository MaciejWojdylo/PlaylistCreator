package com.example.spotifyapp.repository;

import com.example.spotifyapp.model.PlaylistHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistHistoryRepository extends JpaRepository<PlaylistHistory, Long> {
    List<PlaylistHistory> findByUser_Username(String username);
}
