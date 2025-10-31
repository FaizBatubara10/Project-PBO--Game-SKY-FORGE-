import greenfoot.*;

public class playy extends Actor
{
    private GreenfootSound pressSound = new GreenfootSound("press_button.mp3");

    public playy() {
        setImage("play.png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) // suara interaktif ketika button play(pada laman start) ditekan
        {
            pressSound.play();// suara world play dimulai
            start.stopMusic();// suara world start dihentikan
            play newWorld = new play(); //pindah ke world play
            newWorld.playMusic();
            Greenfoot.setWorld(newWorld);
        }
    }
}