import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Soul extends Actor
{
    private int health = 30;
    private int damageTimer = 100;
    private boolean noTouch = false;
    private int speed = 2;
    private String item1 = "Empty";
    private int ghostSpearTimer = 50;
    private int ghostSpearSpam = 0;
    private boolean holder = true;
    private int expNum = 0;
    public static int killCount = 0;
    private int killCountHold = 0;

    /**
     * Act - do whatever the Soul wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().showText(null , getX(), getY() - 40);
        moveAndTurn();
        damage();
        speedyGhost();
        ghostSpear();
        nextLevel();
        death();
        experience();
        getWorld().showText("Hp: " + health, getX(), getY() - 40);
    }

    /**
     * 
     */
    public void moveAndTurn()
    {
        if (Greenfoot.isKeyDown("w")) {
            setRotation(270);
            move(speed);
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("s")) {
            setRotation(90);
            move(speed);
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("a")) {
            setRotation(180);
            move(speed);
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("d")) {
            setRotation(0);
            move(speed);
            setRotation(0);
        }
    }

    /**
     * 
     */
    public void damage()
    {
        if (noTouch == false) {
            if (isTouching(Monster.class)) {
                health = health - 5;
                noTouch = true;
            }
        }
        if (noTouch == true) {
            if (damageTimer > 0) {
                damageTimer = damageTimer - 1;
            }
            if (damageTimer == 0) {
                noTouch = false;
                damageTimer = 100;
            }
        }
    }

    /**
     * 
     */
    public void speedyGhost()
    {
        Actor SpeedyGhost = getOneIntersectingObject(SpeedyGhost.class);
        if (SpeedyGhost != null) {
            World world = getWorld();
            world.removeObject(SpeedyGhost);
            speed = 3;
        }
    }

    /**
     * 
     */
    public void VamCape()
    {
        Actor VamCape = getOneIntersectingObject(VamCape.class);
        if (VamCape != null) {
            World world = getWorld();
            world.removeObject(VamCape);
            item1 = "VamCape";
        }
        while (item1 == "VamCape") {
        }
    }

    /**
     * 
     */
    public void ghostSpear()
    {
        List ghostSpearInWorld = getWorld().getObjects(GhostSpear.class);
        if (Greenfoot.isKeyDown("space")) {
            if (ghostSpearInWorld.size() == 0) {
                getWorld().addObject( new GhostSpear(), getX() + 25, getY());
            }
            holder = false;
        }
        if (ghostSpearTimer > 0) {
            ghostSpearTimer = ghostSpearTimer - 1;
        }
        if (ghostSpearTimer == 0) {
            getWorld().removeObjects(getWorld().getObjects(GhostSpear.class));
            ghostSpearTimer = 50;
            holder = true;
        }
    }

    public void nextLevel()
    {
        if (getWorld().getObjects(Soul.class) != null)
        {
            if (isTouching(Door.class))
            {
                World room2 = new Room2();
                room2.addObject(this, 10, 200);
                Greenfoot.setWorld(room2);
            }
        }
    }
    
    public void death()
    {
        if (health == 0)
        {
            Greenfoot.setWorld(new EndGame());
        }
    }
    
    public static int killCounter()
    {
        return killCount;
    }
    
    public void experience()
    {
        if(killCount > killCountHold)
        {
            expNum += 10;
            killCountHold++;
        }
    }
}
