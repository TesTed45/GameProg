import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoulTears here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoulTears extends Weapons
{
    GifImage myGif = new GifImage("Soul Tear.gif");
    private int weaponReloadTimer = 15;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tears();
        soulMovement();
        spawnTears();
        setImage (myGif.getCurrentImage());
    } 

    public void tears()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (getWorld().getObjects(Soul.class).get(0).getWeapon().equals("SoulTears")) {
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

    public void spawnTears()
    {
        if (getWorld().getObjects(Soul.class).get(0).getWeapon().equals("SoulTears")) {
            weaponReloadTimer--;
            if(Greenfoot.isKeyDown("Space") && weaponReloadTimer <= 0) {
                Tears tears = new Tears();
                getWorld().addObject(tears, getX(), getY());
                tears.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                weaponReloadTimer = 15;
            }
        }
    }
}
