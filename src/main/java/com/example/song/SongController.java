package com.example.song;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.List;
import com.example.song.SongService;
@RestController
class SongController {
   SongService songService=new SongService();
    @GetMapping("/songs")
    public ArrayList<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable int songId) {
        return songService.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PutMapping("/songs/{songId}")
    public void updateSong(@PathVariable int songId, @RequestBody Song song) {
         songService.updateSong(songId, song.getSongName(), song.getSinger());
        return songService.getSongById(songId);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable int songId) {
        songService.deleteSong(songId);
    }
}
