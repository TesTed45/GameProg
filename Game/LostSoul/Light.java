import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Light extends Weapons
{
    GifImage myGif = new GifImage("light.gif");
    private int weaponReloadTimer = 20;
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        light();
        soulMovement();
        spawnLightBalls();
        setImage (myGif.getCurrentImage());
    }

    public void light()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (getWorld().getObjects(Soul.class).get(0).getWeapon().equals("Light")) {
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

    public void spawnLightBalls()
    {
        if (getWorld().getObjects(Soul.class).get(0).getWeapon().equals("Light")) {
            weaponReloadTimer--;
            if(Greenfoot.isKeyDown("Space") && weaponReloadTimer <= 0) {
                LightBalls lightBall = new LightBalls();
                getWorld().addObject(lightBall, getX(), getY());
                lightBall.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
                weaponReloadTimer = 20;
            }
        }
    }
}
