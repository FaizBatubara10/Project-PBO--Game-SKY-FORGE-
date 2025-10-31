import greenfoot.*;

public class gameOver extends World
{
    private GreenfootImage bg;
    private int meteorTimer = 0;

    // Suara game over
    private static GreenfootSound gameOverMusic = new GreenfootSound("gameover.mp3");

    public gameOver(int finalScore)
    {    
        super(1300,700,1,false);
        bg = new GreenfootImage("p2.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        // Tulisan SCORE AKHIR
        GreenfootImage scoreText = new GreenfootImage("SCORE AKHIR: " + finalScore, 60, Color.RED, new Color(0,0,0,0));
    
        getBackground().drawImage(scoreText, getWidth()/2 - scoreText.getWidth()/2, 230);

        restart Restart = new restart();
        addObject(Restart, 500, 350);

        home Home = new home();
        addObject(Home, 800, 350);

        // Musik world start dan play berhenti ketika ganti world ke game over
        start.stopMusic();
        play.stopMusic();

        // looping musik
        gameOverMusic.playLoop();
    }

    public static void stopMusic() {
        gameOverMusic.stop();
    }

    public void act() {
        spawnMeteor();
    }

    private void spawnMeteor() {
        meteorTimer++;
        if (meteorTimer > Greenfoot.getRandomNumber(80) + 80) {
            meteorTimer = 0;
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(100);
            addObject(new meteor(), x, y);
        }
    }
}
