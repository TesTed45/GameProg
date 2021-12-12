import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmallHellhounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallHellhound extends Monsters
{
    private int monsterHealth = 60;
    private int damageTimer = 25;
    private boolean noTouch = false;
    private int saltTimer = 100;
    private boolean saltTouch = false;
    private int followTimer = 150;
    private boolean noFollow = false;
    private boolean movingVertically = Greenfoot.getRandomNumber(2) == 0;
    
    /**
     * Act - do whatever the Hellhounds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().showText("Hp: " + monsterHealth, 500, 100);
        takeDamage();
        if (this.getWorld() != null) {
            if (getWorld().getObjects(Soul.class).get(0).getHolyItem().equals("SatanicPendant")) {
                if (noFollow == false) {
                    if (followTimer > 0) {
                        followTimer = followTimer - 1;
                    }
                    if (followTimer == 0) {
                        followPlayer();
                    }
                }
            } else {
                followPlayer();
            }
        }
    }
    
    private void followPlayer()
    {
        Actor actor = (Actor)getWorld().getObjects(Soul.class).get(0);
        int coordX = this.getX();
        int coordY = this.getY();
        if (actor.getX() > coordX + 50) {
            setLocation(getX() + Greenfoot.getRandomNumber(2), getY());
        }
        if (actor.getX() < coordX - 50) {
            setLocation(getX() - Greenfoot.getRandomNumber(2), getY());
        }
        if (actor.getY() > coordY + 50) {
            setLocation(getX(), getY() + Greenfoot.getRandomNumber(2));
        }
        if (actor.getY() < coordY - 50) {
            setLocation(getX(), getY() - Greenfoot.getRandomNumber(2));
        }
    }
    
    public void takeDamage()
    {
        if (getWorld().getObjects(Soul.class).get(0).getHolyItem().equals("Salt")) {
            if (saltTouch == false) {
                if (isTouching(Soul.class)) {
                    monsterHealth = monsterHealth - 5;
                    saltTouch = true;
                }
            }
            if (saltTouch == true) {
                if (saltTimer > 0) {
                    saltTimer = saltTimer - 1;
                }
                if (saltTimer == 0) {
                    saltTouch = false;
                    saltTimer = 100;
                }
            }
        }
        if (monsterHealth > 0) {
            if (noTouch == false) {
                if (isTouching(SoulSpear.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                }
                if (isTouching(DemonSpear.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                }
                if (isTouching(BeastsClaws.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                }
                if (isTouching(LightBalls.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                }
                if (isTouching(FireBalls.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                }
                if (isTouching(Tears.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                }
            }
            if (noTouch == true) {
                if (damageTimer > 0) {
                    damageTimer = damageTimer - 1;
                }
                if (damageTimer == 0) {
                    noTouch = false;
                    damageTimer = 25;
                }
            }
        }
        if (monsterHealth == 0) {
            Health health0 = new Health();
            if (getWorld().getObjects(Soul.class).get(0).getHolyItem().equals("VampiricCape")) {
                getWorld().addObject(health0, getX() - 25, getY());
            }
            Health health = new Health();
            getWorld().addObject(health, getX(), getY());
            getWorld().removeObject(this);
            Soul.SHKillCount += 1;
        }
    }
}
