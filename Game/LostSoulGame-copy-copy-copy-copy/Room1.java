import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Room1 extends World
{

    private int randomHolyGen = Greenfoot.getRandomNumber(125);
    private int randomStatGen = Greenfoot.getRandomNumber(125);
    private int randomWeaponsGen = Greenfoot.getRandomNumber(125);
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
        Rug rug = new Rug();
        addObject(rug,404,309);
        BedTop bedTop = new BedTop();
        addObject(bedTop,52,84);
        BookshelfTop bookshelfTop = new BookshelfTop();
        addObject(bookshelfTop,181,23);
        bookshelfTop.setLocation(184,39);
        removeObject(bookshelfTop);
        TableTop tableTop = new TableTop();
        addObject(tableTop,166,18);
        tableTop.setLocation(176,47);
        bedTop.setLocation(66,84);
        BookshelfLeft bookshelfLeft = new BookshelfLeft();
        addObject(bookshelfLeft,32,517);
        BookshelfBot bookshelfBot = new BookshelfBot();
        addObject(bookshelfBot,166,575);
        TableBot tableBot = new TableBot();
        addObject(tableBot,688,570);
        BookshelfRight bookshelfRight = new BookshelfRight();
        addObject(bookshelfRight,772,518);
        tableBot.setLocation(694,566);
        bookshelfRight.setLocation(755,555);
        bookshelfRight.setLocation(763,546);
        CouchRight couchRight = new CouchRight();
        addObject(couchRight,760,86);
        TableRight tableRight = new TableRight();
        addObject(tableRight,771,221);
        tableRight.setLocation(758,238);
        BookshelfTop bookshelfTop2 = new BookshelfTop();
        addObject(bookshelfTop2,581,20);
        bookshelfTop2.setLocation(589,60);
        bookshelfBot.setLocation(173,555);
        tableRight.setLocation(744,207);
        bookshelfRight.setLocation(772,468);
        tableBot.setLocation(658,553);
        bookshelfRight.setLocation(772,533);
        bookshelfBot.setLocation(169,566);
        tableRight.setLocation(766,232);
        bookshelfTop2.setLocation(600,46);
        bookshelfBot.setLocation(159,560);
        bookshelfRight.setLocation(738,532);
        tableBot.setLocation(650,556);
        tableBot.setLocation(652,566);
        bookshelfRight.setLocation(750,535);
        bookshelfTop2.setLocation(603,38);
        bookshelfRight.setLocation(775,478);
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

        if (randomHolyGen < 25)
        {
            addObject(new AngelFeather(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomHolyGen < 50)
        {
            addObject(new Salt(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomHolyGen < 75)
        {
            addObject(new SatanicPendant(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomHolyGen < 100)
        {
            addObject(new VampiricCape(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        if (randomStatGen < 25)
        {
            addObject(new OPSoul(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomStatGen < 50)
        {
            addObject(new SpeedySoul(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomStatGen < 75)
        {
            addObject(new TankySoul(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomStatGen < 100)
        {
            addObject(new ToughSoul(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        if (randomWeaponsGen < 25)
        {
            addObject(new BeastsClaws(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomWeaponsGen < 50)
        {
            addObject(new Candle(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomWeaponsGen < 75)
        {
            addObject(new Light(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
        else if (randomWeaponsGen < 100)
        {
            addObject(new SoulTears(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        }
    }
}
