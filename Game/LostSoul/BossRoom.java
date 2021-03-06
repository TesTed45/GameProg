import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossRoom extends World
{

    /**
     * Constructor for objects of class BossRoom.
     * 
     */
    public BossRoom()
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
        BigDemon bigDemon = new BigDemon();
        addObject(bigDemon,409,33);
        bigDemon.setLocation(395,237);
        bigDemon.setLocation(394,184);
    }
}
