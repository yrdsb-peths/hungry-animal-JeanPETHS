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
    SpeedUp speedUp;
    SpeedDown speedDown;
    
    public int score = 0;
    Label scoreLabel;
    
    int level = 1;
    Label levelLabel;
    
    Label speedLabel;
    
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
        
        //Create a level label
        levelLabel = new Label("Level: " + level, 30);
        addObject(levelLabel,535,30);
        
        //Create a speed label
        speedLabel = new Label("Speed: " + elephant.speedElephant, 30);
        addObject(speedLabel,538,55);
        
        createRandom();
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
            setLevelLabel();
            
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
     * Set value of Level Label
     */
    public void setLevelLabel()
    {
        levelLabel.setValue("Level: " + level);
    }
    
    /**
     * Set value of Speed Label
     */
    public void setSpeedLabel(int speedElephant)
    {
        speedLabel.setValue("Speed: " + speedElephant);
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
     * Create a new speed-up at random location at top of screen
     */
    public void createSpeedUp()
    {
        speedUp = new SpeedUp();
        speedUp.setSpeed(level);
        addObject(speedUp, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Create a new speed-down at random location at top of screen
     */
    public void createSpeedDown()
    {
        speedDown = new SpeedDown();
        speedDown.setSpeed(level);
        addObject(speedDown, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Randomly put apple, knife, bomb, speed-up at random location at top of screen
     */
    public void createRandom()
    {
        int num = Greenfoot.getRandomNumber(9);
        if(num==3)
        {
            createBomb();
            if(score > 5)
            {
                createBomb();
            }
        }
        else if(num==2)
        {
            createKnife();
            if(score > 5)
            {
                createKnife();
            }
        }
        else if(num==4)
        {
            createSpeedUp();
        }
        else if(num==5)
        {
            createSpeedDown();
            if(score > 5)
            {
                createSpeedDown();
            }
        }
        else
        {
            createApple();
        }
    }
}
