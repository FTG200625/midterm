package kelas;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String passeword;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    UserBehavior behavior ;
    private ArrayList<Playlist> playlist = new ArrayList<>();
    static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String passeword){
        int mistake = 0;;
        if (username == null || username.isEmpty()){
            throw new InvalidOperationException("Username can not be empty.");
        }
        for (User u : allUsers){
            if (u.username.equals(username))
                mistake = 1;
        }
        if (mistake == 1){
            throw new InvalidOperationException("this user has already exist.");
        }
        if (passeword == null){
            throw new InvalidOperationException("password can not be empty.");
        }
        this.username = username;
        this.passeword = passeword;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow(User user){
        if (this.followingList.contains(user)){
            throw new InvalidOperationException("You have already followed this user.");
        }
            this.followingList.add(user);
            //user.getFollowerList().add(this);
        
    }
    public void createPlaylist (String title){
        this.behavior.createPlaylist(title, this);
    }
    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }
    public void buyPremium(int month) {
        this.behavior.buyPremium(this, month);
    }

    //getter setter
    public String getPassword() {
        return passeword;
    }
    public List<User> getFollowerList() {
        return followerList;
    }
    public List<Playlist> getPlaylist() {
        return playlist;
    }
    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
}
