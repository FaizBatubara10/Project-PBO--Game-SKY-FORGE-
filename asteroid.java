import greenfoot.*;  

public class asteroid extends Actor
{
    private int timer = 0;
    private boolean goingUp = true;
    private int speed = 2;
    private GreenfootImage[] destroy;
    private int frame = 0;
    private boolean isDestroy = false;

    public asteroid() { 
        destroy = new GreenfootImage[4]; 
        for (int i = 0; i < 4; i++) {
            destroy[i] = new GreenfootImage("Destroyed(4-" + (i + 1) + ").png");
        }
    }

    public void act()
    {
       if (!isDestroy) {
    // spawn asteroid naik turun
        if (goingUp) {
        setLocation(getX(), getY() - speed);
        if (getY() <= 50) goingUp = false;
        } else {
        setLocation(getX(), getY() + speed);
        if (getY() >= 600 && getWorld() != null) {
            getWorld().removeObject(this);
            return;
            }
        }

    // cek tabrakan denggan roket atau laser p2 (player utama)
    Actor r1Bullet = getOneIntersectingObject(r1.class);
    Actor l2Bullet = getOneIntersectingObject(l2.class);

        if (r1Bullet != null && getWorld() != null) {
            getWorld().removeObject(r1Bullet);
            isDestroy = true;
            timer = 0;
            frame = 0;
            return;
        }
        if (l2Bullet != null && getWorld() != null) {
            getWorld().removeObject(l2Bullet);
            isDestroy = true;
            timer = 0;
            frame = 0;
            return;
        }
        } else {
    // animasi asteroid hancur
        timer++;
        if (timer % 5 == 0 && frame < destroy.length) {
            setImage(destroy[frame]);
            frame++;
        }
        if (frame >= destroy.length && getWorld() != null) {
            getWorld().removeObject(this);
        }
    }

    }
}
