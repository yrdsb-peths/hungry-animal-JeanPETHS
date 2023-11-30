import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedLabel extends Label
{
    SimpleTimer timer;
    MyWorld world;
    
    public AnimatedLabel(String value, int font) {
        super(value, font);
        timer = new SimpleTimer();
        timer.mark();
    }
    
    public void addedToWorld(World world) {
        if(world instanceof MyWorld) {
            this.world = (MyWorld) world;
        }
    }
    
    /**
     * Act - do whatever the AnimatedLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY()-1);
        if(timer.millisElapsed()>500) {
            world.removeObject(this);
        }
    }
}
