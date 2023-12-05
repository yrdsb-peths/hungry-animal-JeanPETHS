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
    SimpleTimer animationTimer;

    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound bombSound = new GreenfootSound("bombExplosion.wav");
    
    //Elephant animation images
    GreenfootImage[] idleRight = new GreenfootImage[8];
    int imageIndex = 0;
    
    int speedElephant = 2;
    
    //Direction the elephant is facing
    String facing = "right";
    
    boolean isJumping = false;
    static final private int initialSpeed = 20;
    static final private int gravity = 2;
    int velocity;
    
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
            move(-speedElephant);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(speedElephant);
            facing = "right";
        }
        
        //Check if the elephant can jump
        if(Greenfoot.isKeyDown("w") && isOnGround() && !isJumping)
        {
            isJumping = true;
            velocity = initialSpeed;
        }
        
        //Make the elephant jump
        if(isJumping) {
            setLocation(getX(), getY()-velocity);
            velocity -= gravity;
            if(isOnGround()) {
                velocity = 0;
                setLocation(getX(), 300);
                isJumping = false;
            }
        }
        
        //Animate the elephant
        animateElephant();
        
        //Remove apple, knife, speed-up, speed-down if elephant eats it
        if(isTouching(Apple.class) || isTouching(Knife.class) || isTouching(SpeedUp.class) || isTouching(SpeedDown.class))
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
    
    public boolean isOnGround() {
        return getY() == 300;
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
     * Eat apple, knife, speed-up, speed-down, and spawn new objects if anything is eaten
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
        else if(isTouching(Knife.class))
        {
            removeTouching(Knife.class);
            world.decreaseScore();
        }
        else if(isTouching(SpeedUp.class))
        {
            removeTouching(SpeedUp.class);
            speedElephant++;
            world.setSpeedLabel(speedElephant);
        }
        else
        {
            removeTouching(SpeedDown.class);
            speedElephant--;
            world.setSpeedLabel(speedElephant);
        }
        
        //Randomly put apple, knife, bomb, speed-up, speed-down at random location at top of screen
        world.createRandom();
    }
}
