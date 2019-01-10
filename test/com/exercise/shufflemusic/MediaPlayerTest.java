package com.exercise.shufflemusic;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author ganeshk.v
 * Unit test class for the Media player class
 */
public class MediaPlayerTest {
  private List<Song> disc = new ArrayList<>();

  @Before
  public void initialiseSongs() {
    disc.add(new Song("Song 1"));
    disc.add(new Song("Song 2"));
    disc.add(new Song("Song 3"));
    disc.add(new Song("Song 4"));
    disc.add(new Song("Song 5"));

  }

  @Test
  public void shuffleAndPlaySongTest() {
    MediaPlayer mediaPlayer = new MediaPlayer(disc);
    assertTrue(mediaPlayer.shuffleAndPlaySong());
    assertTrue(mediaPlayer.shuffleAndPlaySong());
    assertTrue(mediaPlayer.shuffleAndPlaySong());
    assertTrue(mediaPlayer.shuffleAndPlaySong());
    assertTrue(mediaPlayer.shuffleAndPlaySong());
    assertTrue(!mediaPlayer.shuffleAndPlaySong());

  }



  @Test
  public void playNextSongTest() {
    MediaPlayer mediaPlayer = new MediaPlayer(disc);
    assertTrue(mediaPlayer.playNextSong());
    assertTrue(mediaPlayer.playNextSong());
    assertTrue(mediaPlayer.playNextSong());

    mediaPlayer.playPreviousSong();
    mediaPlayer.playPreviousSong();
    mediaPlayer.playPreviousSong();

    assertTrue(mediaPlayer.playNextSong());
    assertTrue(mediaPlayer.playNextSong());
    assertTrue(mediaPlayer.playNextSong());
    assertTrue(mediaPlayer.playNextSong());
    assertTrue(mediaPlayer.playNextSong());
    assertTrue(!mediaPlayer.playNextSong());

  }

  @Test
  public void playPreviousSongsTest() {
    MediaPlayer mediaPlayer = new MediaPlayer(disc);
    assertTrue(!mediaPlayer.playPreviousSong());
    
    mediaPlayer.playNextSong();
    mediaPlayer.playNextSong();
    mediaPlayer.playNextSong();
    mediaPlayer.playNextSong();
    mediaPlayer.playNextSong();
    
    assertTrue(mediaPlayer.playPreviousSong());
    assertTrue(mediaPlayer.playPreviousSong());
    assertTrue(mediaPlayer.playPreviousSong());
    assertTrue(mediaPlayer.playPreviousSong());
    assertTrue(mediaPlayer.playPreviousSong());
    assertTrue(!mediaPlayer.playPreviousSong());


  }

  @After
  public void destroy() {
    disc.clear();
  }


}
