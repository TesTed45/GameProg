import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room3 extends World
{
    private int randomHolyGen = Greenfoot.getRandomNumber(125);
    private int randomStatGen = Greenfoot.getRandomNumber(125);
    private int randomWeaponsGen = Greenfoot.getRandomNumber(125);
    /**
     * Constructor for objects of class Room3.
     * 
     */
    public Room3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Rug rug = new Rug();
        addObject(rug,424,322);
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
        SadSoul monster =  new SadSoul();
        addObject(monster, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        SmallHellhound monster1 =  new SmallHellhound();
        addObject(monster1, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        WeepingSoul monster2 =  new WeepingSoul();
        addObject(monster2, Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(400));
        if (Greenfoot.getRandomNumber(100) > 50)
        {
            BookshelfLeft bookshelfLeft = new BookshelfLeft();
            addObject(bookshelfLeft,134,168);
            bookshelfLeft.setLocation(119,186);
            BookshelfBot bookshelfBot = new BookshelfBot();
            addObject(bookshelfBot,234,211);
            bookshelfBot.setLocation(247,218);
            CouchRight couchRight = new CouchRight();
            addObject(couchRight,674,471);
            couchRight.setLocation(602,464);
            couchRight.setLocation(706,185);
            couchRight.setLocation(687,117);
            TableTop tableTop = new TableTop();
            addObject(tableTop,593,69);
            couchRight.setLocation(703,144);
            BookshelfBot bookshelfBot2 = new BookshelfBot();
            addObject(bookshelfBot2,655,572);
            BookshelfBot bookshelfBot3 = new BookshelfBot();
            addObject(bookshelfBot3,181,578);
        }
        else
        {
            BookshelfRight bookshelfRight = new BookshelfRight();
            addObject(bookshelfRight,717,474);
            bookshelfRight.setLocation(674,453);
            BookshelfBot bookshelfBot = new BookshelfBot();
            addObject(bookshelfBot,581,496);
            BookshelfTop bookshelfTop = new BookshelfTop();
            addObject(bookshelfTop,615,61);
            BookshelfRight bookshelfRight2 = new BookshelfRight();
            addObject(bookshelfRight2,666,152);
            TableTop tableTop = new TableTop();
            addObject(tableTop,137,92);
            TableRight tableRight = new TableRight();
            addObject(tableRight,215,166);
        }
        
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
