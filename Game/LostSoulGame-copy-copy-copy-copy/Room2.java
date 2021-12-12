import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room2 extends World
{

    /**
     * Constructor for objects of class Room2.
     * 
     */
    public Room2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
        addObject(doorLeft,777,319);
        DoorLeft doorLeft2 = new DoorLeft();
        addObject(doorLeft2,19,320);
        doorLeft.setLocation(760,329);
        removeObject(doorLeft);
        DoorRight doorRight = new DoorRight();
        addObject(doorRight,780,320);
        DoorUp doorUp = new DoorUp();
        addObject(doorUp,421,18);
        WeakDemon monster =  new WeakDemon();
        addObject(monster, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        WeepingSoul monster1 =  new WeepingSoul();
        addObject(monster1, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
    }
}
