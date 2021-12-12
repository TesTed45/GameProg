import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Room1 extends World
{

    /**
     * Constructor for objects of class NewRoom.
     */
    public Room1()
    {
        super(800, 600, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        DoorLeft doorLeft = new DoorLeft();
        addObject(doorLeft,20,319);
        DoorUp doorUp = new DoorUp();
        addObject(doorUp,401,19);
        DoorRight doorRight = new DoorRight();
        addObject(doorRight,779,332);
        doorRight.setLocation(780,319);
        doorLeft.setLocation(32,327);
        doorUp.setLocation(416,24);
        doorLeft.setLocation(23,330);
        doorUp.setLocation(414,28);
        doorUp.setLocation(409,30);
        doorUp.setLocation(424,9);
        doorLeft.setLocation(16,323);
        Soul soul = new Soul();
        addObject(soul,379,564);
        soul.setLocation(421,571);
        Soul soul2 = new Soul();
        addObject(soul2,429,423);
        removeObject(soul);
        soul2.setLocation(441,450);
        soul2.setLocation(375,502);
        soul2.setLocation(399,540);
        WeakDemon monster =  new WeakDemon();
        addObject(monster, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
    }
}
