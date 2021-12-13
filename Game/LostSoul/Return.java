import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Return here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Return extends Buttons
{
    /**
     * Act - do whatever the Return wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("return button highlighted.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("return button.png");
        }

        if (Greenfoot.mouseClicked(this))
        {
            World world = new StartScreen();
            Greenfoot.setWorld(world);
        }

    }

    public boolean getMouseClick() {
        if (Greenfoot.mouseClicked(this)) {
            return true;
        } else {
            return false;
        }
    }
}
