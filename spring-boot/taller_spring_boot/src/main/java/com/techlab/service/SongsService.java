package com.techlab.service;

import com.techlab.model.Song;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SongsService {

  // ESTO DEBERIA IR EN EL REPO
  private List<Song> songs = cancionesEjemplo();

  public Song createSong(Song song) {
    song.addId();
    songs.add(song);
    return song;
  }

  public List<Song> listSongs() {
    return this.songs;
  }

  private List<Song> cancionesEjemplo() {
    List<Song> canciones = new ArrayList<>();

    canciones.add(
        new Song("Luz de Otoño", "Una balada suave sobre los cambios de la vida.", 245));
    canciones.add(new Song("Ecos del Mar",
        "Canción instrumental con sonidos de olas y guitarras acústicas.", 310));
    canciones.add(
        new Song("Corazón de Fuego", "Rock alternativo con letras intensas y energía vibrante.",
            278));
    canciones.add(new Song("Noche Infinita",
        "Tema electrónico con ritmos envolventes y atmósfera misteriosa.", 332));
    canciones.add(new Song("Camino al Sol",
        "Pop motivacional sobre seguir tus sueños y superar obstáculos.", 221));
    return canciones;
  }
}
