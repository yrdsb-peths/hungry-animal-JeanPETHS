import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    MyWorld world;
    int speed;
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY()+speed);
        
        //Remove apple & draw game over when apple gets to bottom
        world = (MyWorld) getWorld();
        if(getY()>=world.getHeight())
        {
            world.removeObject(this);
            world.createApple();
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
