import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class MyWorld here.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel = new Label(score, 80);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        
        //Create a label
        
        addObject(scoreLabel,50,50);
        
        createApple();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        Apple apple = new Apple();
        addObject(apple, Greenfoot.getRandomNumber(600), 0);
    }
}
