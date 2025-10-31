import greenfoot.*;

public class play extends World
{
    private GreenfootImage bg;
    private int scrollX = 0;
    private int spawnTimer = 0;
    private int meteorTimer = 0;
    private int shildTimer = 0;
    private boolean spawnNext = true;
    private int score = 0;
    private health nyawa;
    private p2 pesawat2;
    private int asteroidTimer = 0;
    private int maxAsteroids = 7;

    private static GreenfootSound playMusic = new GreenfootSound("bcksnd_play.mp3");

    public play()
    {    
        super(1300,700,1,false);
        bg = new GreenfootImage("bg_space.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        pesawat2 = new p2();
        addObject(pesawat2, 100, 300);
        
        nyawa = new health();
        addObject(nyawa, 1100, 50);
        pesawat2.setHealthBar(nyawa);
    }
    
    public void act()
    {
        scrollBackground();
        spawnEnemy();
        spawnMeteor();
        spawnShild();
        spawnAsteroid();
        showText("SCORE: " + score, 100, 50);
    }
    
    private void spawnAsteroid()
    {
        asteroidTimer++;

        int asteroidCount = getObjects(asteroid.class).size();

        if (asteroidCount < maxAsteroids && asteroidTimer > 150)
        {
            int[] xPositions = {200, 650, 1100};
            int[] yPositions = {50, 200, 350, 500, 600};

            int randomX = xPositions[Greenfoot.getRandomNumber(xPositions.length)];
            int randomY = yPositions[Greenfoot.getRandomNumber(yPositions.length)];

            addObject(new asteroid(), randomX, randomY);

            asteroidTimer = 0;
        }
    }
    
    private void scrollBackground()
    {
        scrollX -= 1;
        if (scrollX <= -bg.getWidth()) scrollX = 0;
        GreenfootImage worldbg = new GreenfootImage("bg_space.png");
        worldbg.drawImage(bg, scrollX, 0);
        worldbg.drawImage(bg, scrollX + bg.getWidth(), 0);
        setBackground(worldbg);
    }

    private void spawnEnemy() {
        spawnTimer++;
        if (spawnTimer > 150) {
            int randomY = 100 + Greenfoot.getRandomNumber(getHeight() - 200);
            int startX = getWidth() - 50;
            if (spawnNext) addObject(new p1(), startX, randomY);
            else addObject(new p3(), startX, randomY + 100);
            spawnNext = !spawnNext;
            spawnTimer = 0;
        }
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

    private void spawnShild() {
        shildTimer++;
        if (shildTimer > 600) {
            int y = Greenfoot.getRandomNumber(getHeight() - 100) + 50;
            addObject(new shild(), getWidth(), y);
            shildTimer = 0;
        }
    }
    
    public void addScore(int value) { score += value; }
    public int getScore() { return score; }

    public static void playMusic() { playMusic.playLoop(); }
    public static void stopMusic() { playMusic.stop(); }

    public void started() { playMusic.playLoop(); }
    public void stopped() { playMusic.stop(); }
}
