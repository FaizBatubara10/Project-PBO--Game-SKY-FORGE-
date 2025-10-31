import greenfoot.*;

public class start extends World
{
    private GreenfootImage bg;
    private int meteorTimer = 0;
    
    public start()
    {    
        super(1300,700,1,false);
        bg = new GreenfootImage("p1.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        playy Play = new playy();
        addObject(Play, 650, 300);
        
        how How = new how();
        addObject(How, 1000, 300);
        
        planet Planet = new planet();
        addObject(Planet, 250, 250);
    }
    
    public void act()
    {
        spawnMeteor();
    }

    private void spawnMeteor()
    {
        meteorTimer++;
        if (meteorTimer > Greenfoot.getRandomNumber(80) + 80) {
            meteorTimer = 0;
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(100);
            meteor Meteor = new meteor();
            addObject(Meteor, x, y);
        }
    }
    // music pada world start
    private static GreenfootSound bgMusic = new GreenfootSound("bcksnd_homescreen.mp3");

    public void started() 
    {
        bgMusic.playLoop();
    }

    public void stopped() 
    {
        bgMusic.stop();
    }

    // method static agar music bisa dipanggil di class lain
    public static void stopMusic() {
        bgMusic.stop();
    }public static void playMusic() {
        bgMusic.playLoop();
    }
}
