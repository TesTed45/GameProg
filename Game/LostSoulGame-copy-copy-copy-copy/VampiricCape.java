import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VampiricCape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VampiricCape extends HolyItems
{
    GifImage myGif = new GifImage("vampiric cape.gif");
    /**
     * Act - do whatever the VampiricCape wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
