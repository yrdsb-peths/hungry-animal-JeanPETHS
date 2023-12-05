import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a class called Jump. Objects that inherit this class can jump.
 * 
 * @author Jean 
 * @version Dec 2023
 */
public class Jump extends Actor
{
    static final private int initialSpeed = 20;
    static final private int gravity = 10;
    
    public boolean onGround()
    {
        return this.getY()==300;
    }
    
    public void jump()
    {
        int velocity = initialSpeed;
        do {
            System.out.println(getY());
            setLocation(getX(), getY()-velocity);
            velocity -= gravity;
        } while(!onGround());
    }
}
