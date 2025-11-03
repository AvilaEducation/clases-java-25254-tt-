package com.techlab.controller;

import com.techlab.model.Song;
import com.techlab.service.SongsService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

  private SongsService service;

  public SongController() {
    this.service = new SongsService();
  }

  @PostMapping("/songs")
  public Song createSong(@RequestBody Song song) {
    return this.service.createSong(song);
  }

  @GetMapping("/songs")
  public List<Song> listSongs() {
    return this.service.listSongs();
  }
}
