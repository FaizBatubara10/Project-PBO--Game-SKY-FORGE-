import greenfoot.*;

public class home extends Actor
{
    private GreenfootSound pressSound = new GreenfootSound("press_button.mp3");

    public home() { setImage("home.png"); }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            pressSound.play();
            // suara interaktif ketika button home ditekan
            // hentikan musik game over
            gameOver.stopMusic();
            // suara game over berhenti
            // kembali ke start screen
            Greenfoot.setWorld(new start());
            start.playMusic();
        }
    }
}
