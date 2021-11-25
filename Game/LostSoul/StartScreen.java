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
        super(800, 800, 1); 
        Greenfoot.start();
        showText("Press SPACE to play, but if you don't want then don't", 370, 700);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new NewRoom());
        }
    }
        
}
