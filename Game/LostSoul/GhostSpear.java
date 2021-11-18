import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GhostSpear extends Actor
{

    /**
     * Act - do whatever the GhostSpear wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GhostSpear();
        soulMovement();
    }

    /**
     * 
     */
    public void GhostSpear()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            turnTowards(mi.getX(), mi.getY());
        }
    }

    /**
     * 
     */
    public void soulMovement()
    {
        Actor Soul = getOneIntersectingObject(Soul.class);
        if (isTouching(Soul.class) && Greenfoot.isKeyDown("a")) {
            this.setLocation(Soul.getX() + 25, Soul.getY());
        }
        if (isTouching(Soul.class) && Greenfoot.isKeyDown("w")) {
            this.setLocation(Soul.getX() + 25, Soul.getY());
        }
        if (isTouching(Soul.class) && Greenfoot.isKeyDown("s")) {
            this.setLocation(Soul.getX() + 25, Soul.getY());
        }
        if (isTouching(Soul.class) && Greenfoot.isKeyDown("d")) {
            this.setLocation(Soul.getX() + 25, Soul.getY());
        }
    }
}
