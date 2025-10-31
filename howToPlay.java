import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class start3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class howToPlay extends World
{
    private GreenfootImage bg;
    private int scrollX = 0;
    private int meteorTimer = 0;
    /**
     * Constructor for objects of class start3.
     * 
     */
    private GreenfootSound menuMusic = new GreenfootSound("bcksnd_homescreen.mp3");
    
    public howToPlay()
    {    
        // ukuran gambar world howToPlay
        super(1300,700,1,false);
        bg = new GreenfootImage("p5.png");
        bg.scale(getWidth(), getHeight()); 
        setBackground(bg);
        
        back Back = new back();
        addObject(Back, 1130,80);
        
    }
    
    public void act()
    {
        spawnMeteor();
    }
    
    private void spawnMeteor()
    {
        meteorTimer++;

        // spawn meteor hiasan di layar
        if (meteorTimer > Greenfoot.getRandomNumber(80) + 80) {
            meteorTimer = 0;
    
            int x = Greenfoot.getRandomNumber(getWidth()); 
            int y = Greenfoot.getRandomNumber(100);
            
            meteor Meteor = new meteor();
            addObject(Meteor, x, y);
        }
    }
    public void started() {
        menuMusic.playLoop();
    }

    public void stopped() {
        menuMusic.stop();
    }
}
