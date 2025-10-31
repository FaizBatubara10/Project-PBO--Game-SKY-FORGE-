import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class m2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class l2 extends Actor
{
    /**
     * Act - do whatever the m2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public l2()
    {
        setImage("Charge_1(2-1).png");
    }
    
    public void act()
    {
        move(5);

        // hapus misil jika keluar layar
        if (getX() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}
