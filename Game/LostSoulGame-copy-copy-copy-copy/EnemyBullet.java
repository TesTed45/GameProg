import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Monsters
{
    private int timer = 10;
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(Greenfoot.getRandomNumber(5) + 5);
        if (isAtEdge()) {
           getWorld().removeObject(this); 
        }
        if (isTouching(Soul.class))
        {
            timer--;
        }
        if (timer == 0)
        {
            getWorld().removeObject(this);
            timer = 10;
        }
    }
}
