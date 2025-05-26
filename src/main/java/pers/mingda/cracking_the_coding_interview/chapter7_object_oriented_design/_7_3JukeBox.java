package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.Queue;
import java.util.Set;

public class _7_3JukeBox {}

class JukeBox {

  private CDPlayer cdPlayer;
  private User user;
  private Set<CD> cdCollection;
  private SongSelector ts;

  public JukeBox(
    CDPlayer cdPlayer,
    User user,
    Set<CD> cdCollection,
    SongSelector ts
  ) {
    // ...
  }

  public Song getCurrentSong() {
    return ts.getCurrentSong();
  }

  public void setUser(User u) {
    this.user = u;
  }
}

class CDPlayer {

  private Playlist p;
  private CD c;

  /* Constructors. */
  public CDPlayer(CD c, Playlist p) {
    // ...
  }

  public CDPlayer(Playlist p) {
    this.p = p;
  }

  public CDPlayer(CD c) {
    this.c = c;
  }

  /* Play song */
  public void playSong(Song s) {
    // ...
  }

  /* Getters and setters */
  public Playlist getPlaylist() {
    return p;
  }

  public void setPlaylist(Playlist p) {
    this.p = p;
  }

  public CD getCD() {
    return c;
  }

  public void setCD(CD c) {
    this.c = c;
  }
}

class Playlist {

  private Song song;
  private Queue<Song> queue;

  public Playlist(Song song, Queue<Song> queue) {
    // ...
  }

  public Song getNextSToPlay() {
    return queue.peek();
  }

  public void queueUpSong(Song s) {
    queue.add(s);
  }
}

class CD {
  /* data for id, artist, songs, etc */
}

class Song {
  /* data for id, CD (could be null), title, length, etc */
}

class User {

  private String name;
  private long ID;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getID() {
    return ID;
  }

  public void setID(long id) {
    this.ID = id;
  }

  public User(String name, long ID) {
    // ...
  }

  public User getUser() {
    return this;
  }

  public static User addUser(String name, long id) {
    // ...
    return null;
  }
}

class SongSelector {

  public Song getCurrentSong() {
    // ...
    return null;
  }
}
