import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemonSpear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemonSpear extends Weapons
{
    private String weapon = "";
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        dSpearPickUp();
        dSpear();
        soulMovement();
    }

    public void dSpearPickUp()
    {
        Actor soulDemonSpear = getOneIntersectingObject(Soul.class);
        if (soulDemonSpear != null) {
            weapon = "DemonSpear";
        }
    }

    public void dSpear()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (weapon == "DemonSpear") {
            if (mi != null) {
                turnTowards(mi.getX(), mi.getY());
            }
        }
    }

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
