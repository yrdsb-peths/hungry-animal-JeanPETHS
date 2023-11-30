import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class MyWorld here.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class MyWorld extends World
{
    GreenfootSound gameOverSound = new GreenfootSound("gameOverTrombone.wav");
    
    Apple apple;
    Knife knife;
    Bomb bomb;
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Create a score label
        scoreLabel = new Label(score, 80);
        addObject(scoreLabel,50,50);
        
        createApple();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        gameOverSound.play();
        removeObject(apple);
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Animate the "+1" when there is a change in score
     */
    public void plusOneAnimation()
    {
        AnimatedLabel plusOneLabel = new AnimatedLabel("+1", 30);
        addObject(plusOneLabel, 70, 50);
    }
    
    /**
     * Animate the "-1" when there is a change in score
     */
    public void minusOneAnimation()
    {
        AnimatedLabel plusOneLabel = new AnimatedLabel("-1", 30);
        addObject(plusOneLabel, 70, 50);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        plusOneAnimation();
        score++;
        scoreLabel.setValue(score);
        
        //Level up every 5 points
        if(score%5==0)
        {
            level++;
        }
    }
    
    /**
     * Decrease score
     */
    public void decreaseScore()
    {
        minusOneAnimation();
        score--;
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        apple = new Apple();
        apple.setSpeed(level);
        addObject(apple, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Create a new knife at random location at top of screen
     */
    public void createKnife()
    {
        knife = new Knife();
        knife.setSpeed(level);
        addObject(knife, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Create a new bomb at random location at top of screen
     */
    public void createBomb()
    {
        bomb = new Bomb();
        bomb.setSpeed(level);
        addObject(bomb, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Randomly put apple, knife, bomb at random location at top of screen
     */
    public void createRandom()
    {
        int num = Greenfoot.getRandomNumber(6);
        if(num==3)
        {
            createBomb();
        }
        else if(num==2)
        {
            createKnife();
        }
        else
        {
            createApple();
        }
    }
}
