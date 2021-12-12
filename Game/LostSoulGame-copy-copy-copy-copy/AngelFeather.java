import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AngelFeather here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AngelFeather extends HolyItems
{
    GifImage myGif = new GifImage("AngelFeather.gif");
    /**
     * Act - do whatever the AngelFeather wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
