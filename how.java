import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class how extends Actor
{
    private GreenfootSound pressSound = new GreenfootSound("press_button.mp3");

    public how()
    {
        setImage("how.png");
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            pressSound.play();  // suara interaktif saat tombol ditekan
            Greenfoot.delay(10); // beri sedikit jeda agar suara dapat terdengar
            Greenfoot.setWorld(new howToPlay());
        }
    }
}
