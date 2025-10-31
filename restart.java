import greenfoot.*;

public class restart extends Actor
{
    private GreenfootSound pressSound = new GreenfootSound("press_button.mp3");

    public restart() { setImage("restart.png"); }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            pressSound.play();
            // suara interaktif ketika button restart ditekan
            // hentikan musik game over
            gameOver.stopMusic();
            // suara game over berhenti
            // mulai ulang ke world play
            Greenfoot.setWorld(new play());
            play.playMusic();
        }
    }
}
