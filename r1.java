import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class r1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class r1 extends Actor
{
    /**
     * Act - do whatever the r1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public r1()
    {
        setImage("Charge_2(1-2).png");
    }
    
    public void act()
    {
        // gerak ke kiri (menuju pesawat)
        move(5);

        // hapus misil jika keluar layar
        if (getX() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}
