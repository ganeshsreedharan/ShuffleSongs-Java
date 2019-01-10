package com.exercise.shufflemusic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author ganeshk.v
 * Client application to load songs and play(shuffle) the song
 * User have option to select song by (<) symbol(next song) and
 * allowing user to select previous song by (>) symbol
 */

/**
 * @author ganeshk.v
 *
 */
public class ShuffleSongs {

  private static final char NEXT = '>';//next symbol
  private static final char PREVIOUS = '<';//prevous symbol

  public static void main(String[] args) {

    List<Song> disc = loadSongs();
    System.out.println("-----Enjoy music--------");
    System.out.println("For playing first song/next song,press (>) and for previous song, press(<) ");
   
    //Initialize Media player
    MediaPlayer mediaPlayer = new MediaPlayer(disc);

    boolean hasNextSong = true;
    Scanner sc = new Scanner(System.in);
    //Prompt user to select previous/next song till last song 
    while (hasNextSong) {

      char c = sc.next().charAt(0);

      if (c == NEXT) {
        //hasNextSong will false once all songs played
        hasNextSong = mediaPlayer.playNextSong();
      } else if (c == PREVIOUS) {
        mediaPlayer.playPreviousSong();
      } else {
        System.out.println("invalid key");
      }
    }
    sc.close();

  }

  /**
   * Returns the initialized list disc
   * @return the initialized list disc
   */
  
  private static List<Song> loadSongs() {
    List<Song> disc = new ArrayList<>();
    disc.add(new Song("Song 1"));
    disc.add(new Song("Song 2"));
    disc.add(new Song("Song 3"));
    disc.add(new Song("Song 4"));
    disc.add(new Song("Song 5"));
    disc.add(new Song("Song 6"));
    disc.add(new Song("Song 7"));
    disc.add(new Song("Song 8"));
    disc.add(new Song("Song 9"));
    disc.add(new Song("Song 10"));
    return disc;
  }

}


