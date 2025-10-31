import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class health extends Actor
{
    private GreenfootImage[] heart;
    public int health = 6; // jumlah nyawa maksimum
    /**
     * Act - do whatever the health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public health()
    {
        heart = new GreenfootImage[7];
        heart[0] = new GreenfootImage("health_1.png"); // health bar penuh
        heart[1] = new GreenfootImage("health_2.png");
        heart[2] = new GreenfootImage("health_3.png");
        heart[3] = new GreenfootImage("health_4.png");
        heart[4] = new GreenfootImage("health_5.png");
        heart[5] = new GreenfootImage("health_6.png");
        heart[6] = new GreenfootImage("health_7.png"); //health bar kosong
        
        setImage(heart[6 - health]);
    }
    
    public void setHealth(int hp)
    {
        health = hp;
        if (health < 0) health = 0;
        if (health > 6) health = 6;
        setImage(heart[6 - health]);
    }

    public int getHealth()
    {
        return health;
    }

}