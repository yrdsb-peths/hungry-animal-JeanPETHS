import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knife extends Actor
{
    MyWorld world;
    int speed;
    /**
     * Act - do whatever the Knife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);
        
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
