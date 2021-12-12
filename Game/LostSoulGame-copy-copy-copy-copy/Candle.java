import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Candle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Candle extends Weapons
{
    private int weaponReloadTimer = 18;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        candle();
        soulMovement();
        spawnFireBalls();
    }

    public void candle()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (getWorld().getObjects(Soul.class).get(0).getWeapon().equals("Candle")) {
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

    public void spawnFireBalls()
    {
        if (getWorld().getObjects(Soul.class).get(0).getWeapon().equals("Candle")) {
            weaponReloadTimer--;
            if(Greenfoot.isKeyDown("Space") && weaponReloadTimer <= 0) {
                FireBalls fireBall = new FireBalls();
                getWorld().addObject(fireBall, getX(), getY());
                fireBall.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                weaponReloadTimer = 18;
            }
        }
    }
}
