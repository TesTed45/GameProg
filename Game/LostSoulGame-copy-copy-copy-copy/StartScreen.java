import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start start = new Start();
        addObject(start,282,493);
        Controls controls = new Controls();
        addObject(controls,763,486);
        start.setLocation(293,485);
        controls.setLocation(744,492);
        controls.setLocation(793,485);
        start.setLocation(357,496);
        start.setLocation(343,481);
        start.setLocation(350,486);
        controls.setLocation(796,478);
        
        Greenfoot.start();
    }
}

