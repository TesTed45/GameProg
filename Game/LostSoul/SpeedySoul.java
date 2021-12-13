import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedyGhost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedySoul extends StatBoosters
{
    GifImage myGif = new GifImage("SpeedySoul.gif");
    /**
     * Act - do whatever the SpeedyGhost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
