import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Salt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salt extends HolyItems
{
    GifImage myGif = new GifImage("Salt.gif");
    /**
     * Act - do whatever the Salt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
