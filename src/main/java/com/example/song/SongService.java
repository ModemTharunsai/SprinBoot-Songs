package com.example.song;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int nextSongId=6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

 @Override
    public ArrayList<Song> getAllSongs() {
        Collection<Song>songcollection=playlist.values();
        ArrayList<Song>songs=new ArrayList<>(songcollection);
        return songs;
    }

    @Override
    public Song getSongById(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    @Override
    public Song createSong(Song song) {
        song.setSongId(nextSongId);
        playlist.put(nextSongId, song);
        nextSongId+=1;
        return song;
    }

    @Override
    public void updateSong(int songId, Song updatedSong) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        song.setSinger(updatedSong.getSinger());
    }

    @Override
    public void deleteSong(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
        playlist.remove(songId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
