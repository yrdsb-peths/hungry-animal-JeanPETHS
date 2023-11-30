import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class Elephant here.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class Elephant extends Actor
{
    MyWorld world;

    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound bombSound = new GreenfootSound("bombExplosion.wav");
    
    GreenfootImage[] idleRight = new GreenfootImage[8];
    int imageIndex = 0;
    
    //Direction the elephant is facing
    String facing = "right";
    
    SimpleTimer animationTimer;
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant() {
        for(int i=0; i<idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            idleRight[i].scale(60,60);
        }
        
        animationTimer = new SimpleTimer();
        animationTimer.mark();
        
        //Inital elephant image
        setImage(idleRight[0]);
    }
    
    //Get the current world the elephant is in
    public void addedToWorld(World world) {
        if(world instanceof MyWorld) {
            this.world = (MyWorld) world;
        }
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Move the elephant left & right
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(3);
            facing = "right";
        }
        
        //Animate the elephant
        animateElephant();
        
        //Remove apple and knife if elephant eats it
        if(isTouching(Apple.class) || isTouching(Knife.class))
        {
            eat();
        }
        
        //Remove bomb and game over if elephant eats it
        if(isTouching(Bomb.class))
        {
            bombSound.play();
            removeTouching(Bomb.class);
            world = (MyWorld) getWorld();
            world.gameOver();
        }
    }
    
    /**
     * Animate the elephant
     */
    public void animateElephant()
    {
        //If the time is too short, do not animate.
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        
        animationTimer.mark();
        
        //Set the image based on the direction the elephant is facing
        GreenfootImage current = new GreenfootImage(idleRight[imageIndex]);
        if(facing.equals("left"))
        {
            current.mirrorHorizontally();
        }
        setImage(current);
        imageIndex = (imageIndex + 1) % idleRight.length;
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        elephantSound.play();
        
        //Remove the touching object
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            world.increaseScore();
        }
        else
        {
            removeTouching(Knife.class);
            world.decreaseScore();
        }
        
        //Randomly put apple, knife, bomb at random location at top of screen
        world.createRandom();
    }
}
