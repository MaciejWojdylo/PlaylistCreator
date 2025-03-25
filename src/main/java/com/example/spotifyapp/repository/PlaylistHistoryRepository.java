package com.example.spotifyapp.repository;

import com.example.spotifyapp.model.PlaylistHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistHistoryRepository extends JpaRepository<PlaylistHistory, Long> {
}
