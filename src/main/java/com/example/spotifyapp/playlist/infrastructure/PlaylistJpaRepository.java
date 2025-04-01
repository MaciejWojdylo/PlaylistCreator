package com.example.spotifyapp.playlist.infrastructure;

import com.example.spotifyapp.playlist.domain.Playlist;
import com.example.spotifyapp.playlist.domain.PlaylistRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistJpaRepository extends JpaRepository<Playlist,Long>, PlaylistRepository {
}
