package com.exercise.shufflemusic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * @author ganeshk.v
 *
 * MediaPlayer class handles the logic to shuffle songs 
 * list and play next and previous songs
 */
class MediaPlayer {
  //Played Songs List
  private List<Song> songs = new ArrayList<>();
  
  //Collection to hold played songs
  private List<Song> playedSongs = new LinkedList<>();
  
  //get random song from list
  private Random random = new Random();
  
  //to got next and previous song in played songs
  private ListIterator<Song> playedSongIterator = playedSongs.listIterator();

  /**
   * initialize songs List
   * @param songs list to initialize media player
   */
  
  public MediaPlayer(List<Song> songs) {
    this.songs = songs;

  }

  /**
   * Shuffle the songs list.
   * getting a random song from songs list and playing it also
   * removing the played song.
   * @return <tt>true<tt> if list has songs which are not played 
   */
  public boolean shuffleAndPlaySong() {
    if (!songs.isEmpty()) {
      int songNumber = this.random.nextInt(songs.size());
      Song song = this.songs.get(songNumber);
      if (song != null) {
        song.play();
        songs.remove(songNumber);
        playedSongIterator.add(song);

      }
      return true;
    } else {
      System.out.println("You played all songs.Hope you Enjoyed");
      return false;
    }
  }
  
  /**
   * Playing the the next song .if user is in some previous song
   * it will move forward to the playedSongs else will shuffle/play
   * the songs list
   * @return <tt>true<tt> if played next song in playedSongList else
   * returns shuffleAndPlaySong method
   */
  public boolean playNextSong() {

    if (playedSongIterator.hasNext()) {
      Song song = playedSongIterator.next();
      song.play();
      return true;
    } else {
      return shuffleAndPlaySong();
    }

  }

  /**
   * Playing the the previous song .if user is in some previous song
   * it will move backward to the playedSongs . Disables previous option 
   * once all songs in playedSongslist is finished.
   *
   * @return <tt><true<tt> when played previous song.
   */
  public boolean playPreviousSong() {
    if (this.playedSongIterator.hasPrevious()) {
      Song song = playedSongIterator.previous();
      song.play();
      return true;
    } else {
      System.out.println("No previous songs to play");
      return false;
    }

  }

}


/**
 * @author ganeshk.v
 *
 * representing the song record
 */
class Song {
  private String songName;

  public Song(String songName) {
    this.songName = songName;
  }

  public void play() {
    System.out.println("Played song - :" + songName);
  }

}

