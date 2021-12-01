import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends Buttons
{
    /**
     * Act - do whatever the Controls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         if (Greenfoot.mouseMoved(this))
        {
            setImage("ControlsHighlighted.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("ControlsButton.png");
        }

        if (Greenfoot.mouseClicked(this))
        {

        }
    }
}
