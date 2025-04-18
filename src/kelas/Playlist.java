package kelas;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<Music> musics = new ArrayList<>();
    private User owner;
    private String title;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }
    public void addMusic(Music music, String password){
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("password is wrong!");
        if (musics.contains(music))
            throw new InvalidOperationException("this music has already added to playlist.");
        musics.add(music);
    }
    public void removeMusic(Music music, String password){
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("password is wrong!");
        if (!musics.contains(music))
            throw new InvalidOperationException("this music does not exist.");
        musics.remove(music);
    }
    public void editTitle(String newTitle, String password){
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("password is wrong!");
        this.title = newTitle;
    }
    public ArrayList<Music> searchInPlaylist(String title){
        ArrayList<Music> found = new ArrayList<>();
        for (Music m : musics){
            if (m.getTitle().equals(title))
                found.add(m);
        }
        return found;
    }
    public Music searchInPlaylist(String title, User singer){
        for (Music m : musics){
            if (m.getTitle().equals(title) && m.getSinger().equals(singer))
                return m;
        }
        return null;
    }
    public void playPlaylist() {
        for (Music m : musics) {
            m.play();
        }
    }

}
