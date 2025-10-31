import greenfoot.*;  

public class l1 extends Actor
{
    private int speed = 7; // kecepatan peluru

    public l1()
    {
        setImage("Charge_1(1-1).png");
        setRotation(180); // agar arah laser ke kiri
    }
    
    public void act()
    {
        move(speed); 

        // hapus misil jika keluar layar
        if (getX() < 5 || getX() > getWorld().getWidth() - 5)
        {
            getWorld().removeObject(this);
        }
    }
}
