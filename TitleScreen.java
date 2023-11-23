import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class TitleScreen extends World
{
    Label titleLabel;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        titleLabel = new Label("Hungry Elephant", 80);
        addObject(titleLabel, getWidth()/2, 150);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        //Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,505,85);
        Label label = new Label("Use \"a\" and \"d\" to Move", 50);
        addObject(label,getWidth()/2,235);
        Label label2 = new Label("Press <space> to Start", 50);
        addObject(label2,getWidth()/2,300);
    }
}
