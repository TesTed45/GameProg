import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Monster extends Actor
{
    private int monsterHealth = 50;
    private int damageTimer = 25;
    private boolean noTouch = false;
    private boolean movingVertically = Greenfoot.getRandomNumber(2) == 0;

    public void act()
    {
        getWorld().showText(null , getX(), getY() - 40);
        takeDamage();
        if (this.getWorld() == null) return;
        if (this.getWorld() != null) {
            followPlayer();
        }
        getWorld().showText("Hp: " + monsterHealth, getX(), getY() - 40);
    }
    
    private void followPlayer()
    {
        Actor actor = (Actor)getWorld().getObjects(Soul.class).get(0);
        int coordX = this.getX();
        int coordY = this.getY();
        if (actor.getX() > coordX) {
            setLocation(getX() + 1, getY());
        }
        if (actor.getX() < coordX) {
            setLocation(getX() - 1, getY());
        }
        if (actor.getY() > coordY) {
            setLocation(getX(), getY() + 1);
        }
        if (actor.getY() < coordY) {
            setLocation(getX(), getY() - 1);
        }
        
    }

    public void takeDamage()
    {
        if (monsterHealth > 0) {
            if (noTouch == false) {
                if (isTouching(GhostSpear.class)) {
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
