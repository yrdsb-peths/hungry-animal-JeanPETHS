import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class Elephant here.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    int imageIndex = 0;
    
    //Direction the elephant is facing
    String facing = "right";
    
    /**
     * Constructor - The code that gets run one time when object is created
     */
    public Elephant() {
        for(int i=0; i<idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            idleRight[i].scale(50,50);
        }
        
        //Inital elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    public void animateElephant()
    {
        GreenfootImage current = new GreenfootImage(idleRight[imageIndex]);
        if(facing.equals("left"))
        {
            current.mirrorHorizontally();
        }
        setImage(current);
        imageIndex = (imageIndex + 1) % idleRight.length;
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
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
        
        //Remove apple if elephant eats it
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
