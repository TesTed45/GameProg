import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room4 extends World
{

    /**
     * Constructor for objects of class Room4.
     * 
     */
    public Room4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
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
        WeakDemon monster1 =  new WeakDemon();
        addObject(monster1, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        WeakDemon monster2 =  new WeakDemon();
        addObject(monster2, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        WeakDemon monster3 =  new WeakDemon();
        addObject(monster3, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
    }
}
