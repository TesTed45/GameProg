import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeastsClaws here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeastsClaws extends Weapons
{
    private String weapon = "";
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        clawsPickUp();
        claws();
        soulMovement();
    }

    public void clawsPickUp()
    {
        Actor soulDemonSpear = getOneIntersectingObject(Soul.class);
        if (soulDemonSpear != null) {
            weapon = "Claws";
        }
    }

    public void claws()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (weapon == "Claws") {
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
