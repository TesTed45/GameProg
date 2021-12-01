import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Candle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Candle extends Weapons
{
    private String weapon = "";
    private int weaponTime;
    private int reloadTime;
    private int weaponDelay = 35;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        candlePickUp();
        candle();
        soulMovement();
        spawnFireBalls();
        weaponDelay--;
    }

    public void candlePickUp()
    {
        Actor soulDemonSpear = getOneIntersectingObject(Soul.class);
        if (soulDemonSpear != null) {
            weapon = "Candle";
        }
    }

    public void candle()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (weapon == "Candle") {
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

    public void spawnFireBalls()
    {
        if(Greenfoot.isKeyDown("Space") && weaponDelay >= weaponTime) {
            FireBalls fireBall = new FireBalls();
            getWorld().addObject(fireBall, getX(), getY());
            fireBall.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            weaponDelay = 35;
        }
    }
}
