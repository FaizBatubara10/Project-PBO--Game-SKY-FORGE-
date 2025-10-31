import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class meteor extends Actor
{
    private int speed;
    private int disappear;
    /**
     * Act - do whatever the meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public meteor()
    {
        GreenfootImage img = new GreenfootImage("meteor_1.png");
        img.scale(100, 100);
        img.rotate(120); // rotasi agar meteor menghadap ke kiri bawah
        setImage(img);

        // Kecepatan random antara 3–6
        speed = Greenfoot.getRandomNumber(4) + 3;
        setRotation(120); // 120 derajat = arah kiri bawah
    }
    public void addedToWorld(World world)
    {
        // menentukan ketinggian di mana meteor akan menghilang
        int height = world.getHeight();
        disappear = Greenfoot.getRandomNumber(height / 3) + (height / 3); 
    }
    
    public void act()
    {
        move(speed);
        if (getY() > disappear) {
            getWorld().removeObject(this);
        }
    }
}
