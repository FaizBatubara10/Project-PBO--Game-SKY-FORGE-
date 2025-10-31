import greenfoot.*;

public class shild extends Actor implements Collectible
{
    public shild() {
        GreenfootImage img = new GreenfootImage("Shild.png");
        setImage(img);
    }

    public void act() {
        move(-3);
        if (getX() < 0) {
            getWorld().removeObject(this);
            return;
        }

        // untuk cek apakah bersentuhan dengan player
        p2 player = (p2) getOneIntersectingObject(p2.class);
        if (player != null) {
            onCollect(player);
            return;
        }
    }

    @Override
    public void onCollect(p2 player) {
        // aktifkan efek shield di player
        player.activateShield();

        // menghapus item setelah dikoleksi player
        getWorld().removeObject(this);
    }
}
