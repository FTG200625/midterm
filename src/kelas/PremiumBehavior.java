package kelas;

public class PremiumBehavior implements UserBehavior {
    private int month;

    public PremiumBehavior(int month) {
        this.month = month;
    }

    public int getMonth(){
        return month;
    }

    @Override
    public void createPlaylist(String title, User owner){
        Playlist playlist = new Playlist(title, owner);
        owner.getPlaylist().add(playlist);
    }
    @Override
    public void playMusic (Music music){
        music.play();
    }
    @Override
    public void buyPremium(User owner, int month){
        this.month += month;
    }
}
