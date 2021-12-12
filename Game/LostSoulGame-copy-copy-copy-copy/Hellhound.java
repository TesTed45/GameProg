import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hellhounds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hellhound extends Monsters
{
    private int monsterHealth = 150;
    private int damageTimer = 25;
    private boolean noTouch = false;
    private int saltTimer = 100;
    private boolean saltTouch = false;
    private int followTimer = 150;
    private boolean noFollow = false;
    private boolean movingVertically = Greenfoot.getRandomNumber(2) == 0;
    private boolean delay = false;
    private int delayTime = 30;
    GifImage myGif = new GifImage("hell hound right.gif");
    
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
                    delay = true;
                    setImage("hell hound hurt right.png");
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
                    monsterHealth = monsterHealth - (6 + getWorld().getObjects(Soul.class).get(0).getBonusDamage());
                    noTouch = true;
                    delay = true;
                    setImage("hell hound hurt right.png");
                }
                if (isTouching(DemonSpear.class)) {
                    monsterHealth = monsterHealth - (10 + getWorld().getObjects(Soul.class).get(0).getBonusDamage());
                    noTouch = true;
                    delay = true;
                    setImage("hell hound hurt right.png");
                }
                if (isTouching(BeastsClaws.class)) {
                    monsterHealth = monsterHealth - (14 + getWorld().getObjects(Soul.class).get(0).getBonusDamage());
                    noTouch = true;
                    delay = true;
                    setImage("hell hound hurt right.png");
                }
                if (isTouching(LightBalls.class)) {
                    monsterHealth = monsterHealth - (6 + getWorld().getObjects(Soul.class).get(0).getBonusDamage());
                    noTouch = true;
                    delay = true;
                    setImage("hell hound hurt right.png");
                }
                if (isTouching(FireBalls.class)) {
                    monsterHealth = monsterHealth - (8 + getWorld().getObjects(Soul.class).get(0).getBonusDamage());
                    noTouch = true;
                    delay = true;
                    setImage("hell hound hurt right.png");
                }
                if (isTouching(Tears.class)) {
                    monsterHealth = monsterHealth - (12 + getWorld().getObjects(Soul.class).get(0).getBonusDamage());
                    noTouch = true;
                    delay = true;
                    setImage("hell hound hurt right.png");
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
        if (monsterHealth <= 0) {
            Health health0 = new Health();
            if (getWorld().getObjects(Soul.class).get(0).getHolyItem().equals("VampiricCape")) {
                getWorld().addObject(health0, getX() - 25, getY());
            }
            Health health = new Health();
            getWorld().addObject(health, getX(), getY());
            Health health1 = new Health();
            getWorld().addObject(health1, getX() + 15, getY());
            Health health2 = new Health();
            getWorld().addObject(health2, getX() - 10, getY() + 10);
            getWorld().removeObject(this);
            Soul.HKillCount += 1;
        }
        if (delay)
        {
            delayTime--;
        }
        if (delayTime == 0)
        {
            setImage("hell hound right.gif");
            delay = false;
            delayTime = 30;
        }
    }
}
