package com.example.song;
import java.util.ArrayList;

public interface SongRepository {
    ArrayList<Song> getAllSongs();

    Song getSongById(int songId);

    Song createSong(Song song);

    void updateSong(int songId, Song song);

    void deleteSong(int songId);
}
