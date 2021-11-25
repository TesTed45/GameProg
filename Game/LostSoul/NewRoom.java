import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class NewRoom extends World
{

    /**
     * Constructor for objects of class NewRoom.
     */
    public NewRoom()
    {
        super(800, 800, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Soul soul =  new Soul();
        addObject(soul, 397, 397);
        Health health =  new Health();
        addObject(health, 42, 43);
        Health health2 =  new Health();
        addObject(health2, 105, 45);
        Health health3 =  new Health();
        addObject(health3, 171, 44);
        Monster monster =  new Monster();
        addObject(monster, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        Monster monster2 =  new Monster();
        addObject(monster2, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        SpeedyGhost speedyGhost =  new SpeedyGhost();
        addObject(speedyGhost, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(800));
        VamCape vamCape =  new VamCape();
        addObject(vamCape, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(800));
        soul.setLocation(383,760);
        removeObject(health3);
        removeObject(health2);
        removeObject(health);
        Door door = new Door();
        addObject(door,379,1);
        Door door2 = new Door();
        addObject(door2,2,391);
        Door door3 = new Door();
        addObject(door3,795,397);
    }
}
