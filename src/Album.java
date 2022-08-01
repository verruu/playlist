import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

//    It has three fields, two Strings called name and artist, and an ArrayList
//    that holds objects of type Song called songs.
    private String name;
    private String artist;
    private ArrayList<Song> songs = new ArrayList<Song>();

//    A constructor that accepts two Strings (name of the album and artist).
//    It initialises the fields and instantiates songs.
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

//    public String getName() {
//        return name;
//    }

    //    addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean.
//    Returns true if the song was added successfully or false otherwise.
    public boolean addSong(String title, double duration) {
        Song tempSong = findSong(title);
        if (tempSong == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

//    findSong(), has one parameter of type String (title of song) and returns a Song.
//    Returns the Song if it exists, null if it doesn't exists.
    private Song findSong(String title) {
        for (int i = 0; i < this.songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) return songs.get(i);
        }
        return null;
    }

//    addToPlayList(), has two parameters of type int (track number of song in album) and LinkedList (the playlist)
//    that holds objects of type Song, and returns a boolean.
//    Returns true if it exists and it was added successfully using the track number, or false otherwise.
    public boolean addToPlayList(int trackNumberInAlbum, LinkedList<Song> playlist) {
        if (trackNumberInAlbum > 0 && trackNumberInAlbum <= songs.size()) {
            String song = songs.get(trackNumberInAlbum-1).getTitle();
            return addToPlayList(song, playlist);
        }
        return false;
    }

//    addToPlayList(), has two parameters of type String (title of song) and LinkedList (the playlist)
//    that holds objects of type Song, and returns a boolean.
//    Returns true if it exists and it was added successfully using the name of the song, or false otherwise.
    public boolean addToPlayList(String titleOfSong, LinkedList<Song> playlist) {
        if (findSong(titleOfSong) != null) {
            playlist.add(findSong(titleOfSong));
            return true;
        }
        return false;
    }
}