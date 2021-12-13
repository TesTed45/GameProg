import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SatanicPendant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SatanicPendant extends HolyItems
{
    GifImage myGif = new GifImage("SatanicPendant.gif");
    /**
     * Act - do whatever the SatanicPendant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
