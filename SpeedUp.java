import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that can make the elephant speed up.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class SpeedUp extends Actor
{
    int speed;
    
    /**
     * Act - do whatever the Speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY()+speed);
 
        //Remove speed-up & create apple or knife or bomb or speed-up when speed-up gets to bottom
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
