import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY()+2);
        
        //Remove apple & draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY()>=world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
