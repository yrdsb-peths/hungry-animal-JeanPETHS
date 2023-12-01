import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedDown extends Actor
{
    int speed;
    /**
     * Act - do whatever the SpeedDown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY()+speed);
 
        //Remove speed-down & create apple/knife/bomb/speed-up/speed-down when speed-down gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY()>=world.getHeight())
        {
            world.removeObject(this);
            world.createRandom();
        }
    }
    
    public void setSpeed(int spd)
    {
        this.speed = spd;
    }
}
