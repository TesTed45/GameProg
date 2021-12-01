import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoulTears here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoulTears extends Weapons
{
    private String weapon = "";
    private int weaponTime;
    private int reloadTime;
    private int weaponDelay;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tearsPickUp();
        tears();
        soulMovement();
        spawnTears();
        weaponDelay++;
    }

    public void tearsPickUp()
    {
        Actor soulDemonSpear = getOneIntersectingObject(Soul.class);
        if (soulDemonSpear != null) {
            weapon = "Tears";
        }
    }

    public void tears()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (weapon == "Tears") {
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

    public void spawnTears()
    {
        if(Greenfoot.isKeyDown("Space") && weaponDelay >= weaponTime) {
            Tears tears = new Tears();
            getWorld().addObject(tears, getX(), getY());
            tears.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            weaponDelay = 0;
        }
    }
}
