package kelas;

public class RegularBehavior implements UserBehavior {
    public int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new InvalidOperationException("You can not create playlist.");
    }
    @Override
    public void playMusic(Music music){
        if (playingLimit <= 0){
            throw new InvalidOperationException("The music play limit for you has been reached.");
        }
        else {
            music.play();
            --playingLimit;
        }
    }
    @Override
    public void buyPremium (User owner, int month){
        PremiumBehavior newOne = new PremiumBehavior(month);
        owner.setBehavior(newOne);

    }
}
