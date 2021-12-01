import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Monster extends Monsters
{
    private int monsterHealth = 50;
    private int damageTimer = 25;
    private boolean noTouch = false;
    private boolean movingVertically = Greenfoot.getRandomNumber(2) == 0;

    public void act()
    {
        getWorld().showText("Hp: " + monsterHealth, 500, 100);
        takeDamage();
        if (this.getWorld() != null) {
            followPlayer();
        }
    }
    //BROKEN NEED FIX
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
            getWorld().removeObject(this);
            Soul.killCount += 1;
        }
    }
}
