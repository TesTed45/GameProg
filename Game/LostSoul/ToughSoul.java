import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToughSoul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToughSoul extends StatBoosters
{
    GifImage myGif = new GifImage("ToughSoul.gif");
    /**
     * Act - do whatever the ToughSoul wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
