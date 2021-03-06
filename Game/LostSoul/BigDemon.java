import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigDemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigDemon extends Monsters
{
    private int monsterHealth = 500;
    private int saltTimer = 100;
    private boolean saltTouch = false;
    private boolean noTouch = false;
    private int damageTimer = 25;
    private int timer = 300;
    private boolean delay = false;
    private int delayTime = 30;

    public void act()
    {
        getWorld().showText("Hp: " + monsterHealth, 500, 100);
        takeDamage();
        shoot();
        death();
    }

    public void takeDamage()
    {
        if (getWorld().getObjects(Soul.class).get(0).getHolyItem().equals("Salt")) {
            if (saltTouch == false) {
                if (isTouching(Soul.class)) {
                    monsterHealth = monsterHealth - 5;
                    saltTouch = true;
                    delay = true;
                    setImage("Demon hurt.png");
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
                    delay = true;
                    setImage("Demon hurt.png");
                }
                if (isTouching(DemonSpear.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                    delay = true;
                    setImage("Demon hurt.png");
                }
                if (isTouching(BeastsClaws.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                    delay = true;
                    setImage("Demon hurt.png");
                }
                if (isTouching(LightBalls.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                    delay = true;
                    setImage("Demon hurt.png");
                }
                if (isTouching(FireBalls.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                    delay = true;
                    setImage("Demon hurt.png");
                }
                if (isTouching(Tears.class)) {
                    monsterHealth = monsterHealth - 5;
                    noTouch = true;
                    delay = true;
                    setImage("Demon hurt.png");
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
            Health health1 = new Health();
            getWorld().addObject(health1, getX() + 15, getY());
            getWorld().removeObject(this);
            Soul.SSKillCount += 1;
        }
        if (delay)
        {
            delayTime--;
        }
        if (delayTime == 0)
        {
            setImage("Demon.gif");
            delay = false;
            delayTime = 30;
        }
    }

    public void shoot()
    {
        if (timer == 0) {
            Actor soul = (Actor)getWorld().getObjects(Soul.class).get(0);
            EnemyBullet ennemyBullet = new EnemyBullet();
            getWorld().addObject(ennemyBullet, getX(), getY());
            ennemyBullet.turnTowards(soul.getX(), soul.getY());
            timer = Greenfoot.getRandomNumber(50) + 50;
        }
        else
        {
            timer--;
        }
    }

    public void death()
    {
        if (monsterHealth <= 0)
        {
            World gameWon = new WinScreen();
            gameWon.addObject(this, 10, 200);
            Greenfoot.setWorld(gameWon);
            getWorld().removeObject(this);            
        }
    }
}
