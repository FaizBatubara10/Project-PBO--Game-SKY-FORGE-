import greenfoot.*;

public class back extends Actor
{   
    private GreenfootSound pressSound = new GreenfootSound("press_button.mp3");

    public back() {
        setImage("back.png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            pressSound.play();// suara interaktif ketika button back ditekan
            Greenfoot.setWorld(new start());
        }
    }
}
