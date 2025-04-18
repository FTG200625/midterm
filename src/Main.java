import kelas.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("--->create users: ");

        User user1 = null;
        User user2 = null;
        User hayede = null;
        try {
            user1 = new User("user1", "abc1234");
            user2 = new User("", "hey4444");
            hayede = new User("Haydeh", "140313");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }


        user1.follow(hayede);


        Music music1 = new Music("Saghi", hayede);
        Music music2 = new Music("Eshareh", hayede);

        System.out.println("--->play music: ");
        user1.playMusic(music1);
        try{
            for (int i=0 ; i < 6 ; ++i)
                user1.playMusic(music2);
        }catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }

        System.out.println("--->create playlist: ");
        try {
            user1.createPlaylist("My playlist");
        }catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }


        user1.buyPremium(6);

        try {
            user1.createPlaylist("My playlist");
        }catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }
        System.out.println("--->add and remove songs: ");
        try {
            user1.getPlaylist().get(0).addMusic(music1, "password123");
        }catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }
        try {
            user1.getPlaylist().get(0).addMusic(music1, "abc1234");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        try {
            user1.getPlaylist().get(0).addMusic(music2, "abc1234");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        try {
            user1.getPlaylist().get(0).removeMusic(music2, "abc1234");
        }catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }try {
            user1.getPlaylist().get(0).removeMusic(music2, "abc1234");
        }catch (InvalidOperationException e){
            System.out.println(e.getMessage());
        }

        System.out.println("--->play playlist: ");
        user1.getPlaylist().get(0).playPlaylist();

        System.out.println("--->search: ");
        ArrayList<Music> foundSongs = Music.search("Saghi");
        System.out.println("pley search result: " );
        for (Music m : foundSongs)
            m.play();


    }
}
