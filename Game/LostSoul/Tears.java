import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tears here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tears extends Weapons
{
    int speed = 10;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
        if (isAtEdge()) {
           getWorld().removeObject(this); 
        }
    }
}
