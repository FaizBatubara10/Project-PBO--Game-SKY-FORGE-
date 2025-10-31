import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class l3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class l3 extends Actor
{
    /**
     * Act - do whatever the l3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public l3()
    {
        setImage("Charge_2(3-1).png");
    }
    
    public void act()
    {
        // gerak ke kiri (menuju pesawat player)
        move(-5);

        // hapus misil jika keluar layar
        if (getX() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}
