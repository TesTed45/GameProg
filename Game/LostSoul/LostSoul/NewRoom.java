// WARNING: This file is auto-generated and any changes to it will be overwritten
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
        addObject(monster, 548, 358);
        SpeedyGhost speedyGhost =  new SpeedyGhost();
        addObject(speedyGhost, 260, 395);
        VamCape vamCape =  new VamCape();
        addObject(vamCape, 364, 218);
    }
}
