package kelas;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer){
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }
    public void play(){
        System.out.println(this.title+" is playing...");
        ++numberOfStream;
    }
    public static  ArrayList<Music> search(String title){
        ArrayList<Music> found = new ArrayList<>();

        for ( Music m : allMusics){
            if (m.title.equals(title))
                found.add(m);
        }
        return found;
    }
    public static Music search(String title, User singer){
      for (Music m : allMusics){
          if (m.title.equals(title) && m.singer.equals(singer))
              return m;
      }
      return null;
    }

    //getter, setter
    public String getTitle() {
        return title;
    }
    public User getSinger() {
        return singer;
    }
}
