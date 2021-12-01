import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Light extends Weapons
{
    private String weapon = "";
    private int weaponTime;
    private int reloadTime;
    private int weaponDelay = 50;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        lightPickUp();
        light();
        soulMovement();
        spawnLightBalls();
        weaponDelay--;
    }
    
    public void lightPickUp()
    {
        Actor soulDemonSpear = getOneIntersectingObject(Soul.class);
        if (soulDemonSpear != null) {
            weapon = "Light";
        }
    }

    public void light()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (weapon == "Light") {
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

    public void setReloadTime(int reloadTimer)
    {
        weaponTime = reloadTime;
    }

    public void spawnLightBalls()
    {
        if(Greenfoot.isKeyDown("Space") && weaponDelay >= weaponTime) {
            LightBalls lightBall = new LightBalls();
            getWorld().addObject(lightBall, getX(), getY());
            lightBall.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            weaponDelay = 50;
        }
    }
}
