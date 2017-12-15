package com.example.zsyoc_000.musicplayer;

/**_
 * Created by pawankumar on 30/05/17.
 */

public class SongInfo {
    public String songName,artistName,songUrl;

    public SongInfo() {
    }

    public SongInfo(String songname, String artistname, String songUrl) {
        this.songName = songname;
        this.artistName = artistname;
        this.songUrl = songUrl;
    }

    public String getSongname() {
        return songName;
    }

    public void setSongname(String songname) {
        songName = songname;
    }

    public String getArtistname() {
        return artistName;
    }

    public void setArtistname(String artistname) {
        artistName = artistname;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        songUrl = songUrl;
    }
}