import greenfoot.*;  

public class p2 extends Actor implements Shootable 
{
    private GreenfootImage move;
    private GreenfootImage[] destroy, shoot, damage, shild, rocketAnim;
    private GreenfootImage play;
    private int frame = 0, timer = 0, shildTimer = 0, shildFrame = 0, damageTimer = 0;
    private boolean isDestroy = false, isShild = false, isDamage = false;
    private boolean isShooting = false, isRocketShooting = false;
    private int shootDelay = 0, health = 6;
    private int rocketFrame = 0, rocketTimer = 0;
    private health heart;
    private GreenfootSound shieldSound = new GreenfootSound("shild.mp3");

    public p2() {
        play = new GreenfootImage("Idle(2).png");
        move = new GreenfootImage("Move(2).png");

        damage = new GreenfootImage[6];
        for (int i = 0; i < 6; i++) damage[i] = new GreenfootImage("Damage(2-" + (i + 1) + ").png");

        destroy = new GreenfootImage[10];
        for (int i = 0; i < 10; i++) destroy[i] = new GreenfootImage("Destroyed(2-" + (i + 1) + ").png");

        shild = new GreenfootImage[5];
        for (int i = 0; i < 5; i++) shild[i] = new GreenfootImage("Shild(2-" + (i + 1) + ").png");

        shoot = new GreenfootImage[4];
        for (int i = 0; i < 4; i++) shoot[i] = new GreenfootImage("Attack_1(2-" + (i + 1) + ").png");

        // animasi roket
        rocketAnim = new GreenfootImage[6];
        for (int i = 0; i < 6; i++) {
            rocketAnim[i] = new GreenfootImage("r1(2-" + (i + 1) + ").png");
        }

        setImage(play);
    }

    public void act() {
        if (!isDestroy) {
            moved();
            shoot();
            rocketShootAnimation();
            if (isShild) protect();
            if (isDamage) damaged();
        } else destroyed();
    }

    private void moved() {
        if (Greenfoot.isKeyDown("right")) { move(4); setImage(move); }
        if (Greenfoot.isKeyDown("left"))  { move(-4); setImage(move); }
        if (Greenfoot.isKeyDown("up"))    { setLocation(getX(), getY() - 4); setImage(move); }
        if (Greenfoot.isKeyDown("down"))  { setLocation(getX(), getY() + 4); setImage(move); }

        Actor m1 = getOneIntersectingObject(l1.class);
        Actor m2 = getOneIntersectingObject(l3.class);
        if ((m1 != null || m2 != null) && !isShild) {
            if (m1 != null) getWorld().removeObject(m1);
            if (m2 != null) getWorld().removeObject(m2);
            takeDamage();
        }

        if ((m1 != null || m2 != null) && isShild) {
            if (m1 != null) getWorld().removeObject(m1);
            if (m2 != null) getWorld().removeObject(m2);
        }
    }

    @Override
    public void shoot() {
        shootDelay++;

        // input space untuk mengeluarkan laser
        if (Greenfoot.isKeyDown("space") && shootDelay > 20) {
            setImage(shoot[Greenfoot.getRandomNumber(shoot.length)]);
            getWorld().addObject(new l2(), getX() + 70, getY() - 30);
            getWorld().addObject(new l2(), getX() + 70, getY() + 30);
            Greenfoot.playSound("laser.mp3"); 
            shootDelay = 0;
        }

        // input enter untuk mengeluarkan roket
        if (Greenfoot.isKeyDown("enter") && shootDelay > 40 && !isRocketShooting) {
            isRocketShooting = true;
            rocketFrame = 0;
            rocketTimer = 0;
            shootDelay = 0;
            Greenfoot.playSound("missile.mp3");

            // spawn roket
            getWorld().addObject(new r1(), getX() - 20, getY() - 60);
            getWorld().addObject(new r1(), getX() - 20, getY() + 60);
        }
    }

    // animasi peluncuran roket
    private void rocketShootAnimation() {
        if (isRocketShooting) {
            rocketTimer++;
            if (rocketTimer % 5 == 0 && rocketFrame < rocketAnim.length) {
                setImage(rocketAnim[rocketFrame]);
                rocketFrame++;
            }

            // Reset animasi setelah selesai
            if (rocketFrame >= rocketAnim.length) {
                isRocketShooting = false;
                rocketFrame = 0;
                rocketTimer = 0;
                setImage(play); // kembali ke idle
            }
        }
    }

    private void takeDamage() {
        if (isDamage) return;
        health--;
        isDamage = true;
        damageTimer = 0;
        if (heart != null) heart.setHealth(health);
        if (health <= 0) { isDestroy = true; frame = 0; timer = 0; }
    }

    private void damaged() {
        damageTimer++;
        if (damageTimer < damage.length * 5) {
            if (damageTimer % 5 == 0)
                setImage(damage[(damageTimer / 5) % damage.length]);
        } else { isDamage = false; setImage(move); }
    }

    private void destroyed() {
        timer++;
        if (timer % 10 == 0 && frame < destroy.length) {
            setImage(destroy[frame]);
            frame++;
        }

        if (frame >= destroy.length) {
            play currentWorld = (play)getWorld();
            int finalScore = currentWorld.getScore();
            Greenfoot.setWorld(new gameOver(finalScore));
            getWorld().removeObject(this);
        }
    }

    private void protect() {   
        shildTimer--;
        if (shildTimer <= 0) {
            isShild = false;
            setImage(move);
            shieldSound.stop();
            return;
        }

        if (shildTimer % 5 == 0) {
            setImage(shild[shildFrame]);
            shildFrame = (shildFrame + 1) % shild.length;
        }
    }

    public void activateShield() {   
        if (!isShild) {
            isShild = true;
            shildTimer = 180;
            shildFrame = 0;
            shieldSound.playLoop();
        }
    }

    public void setHealthBar(health h) {
        heart = h;
        heart.setHealth(health);
    }
}
