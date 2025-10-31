import greenfoot.*;

public class p1 extends Actor implements Scorable, Shootable
{
    private GreenfootImage move;
    private GreenfootImage[] destroy;
    private GreenfootImage[] shoot;
    private GreenfootImage[] damage;
    private int frame = 0;
    private int timer = 0;
    private boolean isDestroy = false;
    private boolean isDamage = false;
    private boolean isDamaged = false;
    private int shootDelay = 0;

    public p1()
    {
        move = new GreenfootImage("Move(1).png");

        destroy = new GreenfootImage[6];
        for (int i = 0; i < destroy.length; i++) {
            destroy[i] = new GreenfootImage("Destroyed(1-" + (i + 1) + ").png");
        }

        shoot = new GreenfootImage[3];
        for (int i = 0; i < shoot.length; i++) {
            shoot[i] = new GreenfootImage("Attack_1(1-" + (i + 1) + ").png");
        }

        damage = new GreenfootImage[7];
        for (int i = 0; i < damage.length; i++) {
            damage[i] = new GreenfootImage("Damage(1-" + (i + 1) + ").png");
        }

        setImage(move);
    }

    public void act()
    {
        if (isDestroy) destroyed();
        else if (isDamage) Damaged();
        else {
            moved();
            shoot();
        }
    }

    private void moved()
    {
        move(-5);
        setImage(move);

        Actor misil1 = getOneIntersectingObject(l2.class);
        Actor misil2 = getOneIntersectingObject(r1.class);
        if (misil1 != null || misil2 != null)
        {
            if (misil1 != null) getWorld().removeObject(misil1);
            if (misil2 != null) getWorld().removeObject(misil2);

            if (!isDamaged) {
                isDamage = true;
                isDamaged = true;
                frame = 0;
                timer = 0;
            } else {
                isDestroy = true;
                frame = 0;
                timer = 0;
            }
        }

        if (isDamage && !isDestroy) Damaged();
    }

    @Override
    public void shoot() 
    {
        shootDelay++;
        if (shootDelay > 20)
        {
            setImage(shoot[Greenfoot.getRandomNumber(shoot.length)]);
            l1 peluruAtas = new l1();
            l1 peluruBawah = new l1();
            getWorld().addObject(peluruAtas, getX() - 60, getY() - 15);
            getWorld().addObject(peluruBawah, getX() - 60, getY() + 15);
            shootDelay = 0;
        }
    }


    private void destroyed()
    {
        timer++;
        if (timer % 10 == 0 && frame < destroy.length)
        {
            setImage(destroy[frame]);
            frame++;
        }

        if (frame >= destroy.length)
        {
            if (getWorld() instanceof play)
            {
                play currentWorld = (play) getWorld();
                currentWorld.addScore(getScoreValue());
            }
            getWorld().removeObject(this);
        }
    }

    private void Damaged()
    {
        timer++;
        if (timer % 6 == 0 && frame < damage.length)
        {
            setImage(damage[frame]);
            frame++;
        }

        if (frame >= damage.length)
        {
            isDamage = false;
            setImage(move);
            frame = 0;
            timer = 0;
        }
    }

    @Override
    public int getScoreValue() {
        return 100; // nilai poin untuk musuh p1
    }
}
