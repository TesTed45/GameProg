import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OPSoul here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OPSoul extends StatBoosters
{
    GifImage myGif = new GifImage("OPSoul.gif");
    /**
     * Act - do whatever the OPSoul wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage (myGif.getCurrentImage());
    }
}
