import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Soul extends Actor
{
    private int damageTimer = 100;
    private boolean noTouch = false;

    private int damageByMonsters = 5;

    private String weapon = "SoulSpear";
    private int weaponTimer = 30;
    private boolean weaponHolder = true;

    private String statsBooster = "";
    private int totalHealth = 30;
    private int levelUpHealth;
    private int bonusHealth;
    private int speed;
    private int bonusDamage = 0;
    private int bonusDefense;

    private String holyItem = "";

    private int worldChecker = 1;
    private int expNum = 0;
    public static int WDKillCount = 0;
    public static int LDKillCount = 0;
    public static int SHKillCount = 0;
    public static int HKillCount = 0;
    public static int SSKillCount = 0;
    public static int WSKillCount = 0;
    private int WDKillCountHold = 0;
    private int LDKillCountHold = 0;
    private int SHKillCountHold = 0;
    private int HKillCountHold = 0;
    private int SSKillCountHold = 0;
    private int WSKillCountHold = 0;
    private int level = 0;

    /**
     * Act - do whatever the Soul wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAndTurn();
        damage();
        heal();
        getWorld().showText("Hp: " + totalHealth, 300, 100);
        getWorld().showText("Speed: " + speed, 100, 200);
        getWorld().showText("Damage Timer " + damageTimer, 700, 100);
        getWorld().showText("Damage: " + bonusDamage, 100, 100);
        getWorld().showText("Stat: " + statsBooster, 400, 200);
        getWorld().showText("Bonus HP: " + bonusHealth, 600, 200);

        weapons();
        useWeapons();

        statBoosters();
        useStatBoosters();

        holyItems();

        nextLevel();
        getHolyItem();

        experience();
        levelUp();
    }

    /**
    The Soul's movement
     */
    public void moveAndTurn()
    {
        if (Greenfoot.isKeyDown("w")) {
            if (getOneObjectAtOffset(0, -50, Obstacles.class) == null) {  
                setRotation(270);
                move(speed);
                setRotation(0);
            }
        }
        if (Greenfoot.isKeyDown("s")) {
            if (getOneObjectAtOffset(0, 50, Obstacles.class) == null) {  
                setRotation(90);
                move(speed);
                setRotation(0);
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            if (getOneObjectAtOffset(-50, 0, Obstacles.class) == null) {  
                setRotation(180);
                move(speed);
                setRotation(0);
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            if (getOneObjectAtOffset(50, 0, Obstacles.class) == null) {  
                setRotation(0);
                move(speed);
                setRotation(0);
            }
        }
    }

    /**
     * Monsters damage Soul
     */
    public void damage()
    {
        if (noTouch == false) {
            if (isTouching(WeakDemon.class)) {
                totalHealth = totalHealth - 5;
                noTouch = true;
            }
            if (isTouching(LesserDemon.class)) {
                totalHealth = totalHealth - 10;
                noTouch = true;
            }
            if (isTouching(SmallHellhound.class)) {
                totalHealth = totalHealth - 6;
                noTouch = true;
            }
            if (isTouching(Hellhound.class)) {
                totalHealth = totalHealth - 15;
                noTouch = true;
            }
            if (isTouching(SadSoul.class)) {
                totalHealth = totalHealth - 10;
                noTouch = true;
            }
            if (isTouching(WeepingSoul.class)) {
                totalHealth = totalHealth - 16;
                noTouch = true;
            }
        }
        if (noTouch == true) {
            if (damageTimer > 0) {
                damageTimer = damageTimer - 1;
            }
            if (damageTimer == 0) {
                noTouch = false;
                if (holyItem == "AngelFeather") {
                    damageTimer = 200;
                } else if (holyItem == "Salt" || holyItem == "VampiricCape" || holyItem == "SatanicPendant" || holyItem == "") {
                    damageTimer = 100;
                }
            }
        }
    }

    public int getDamageTimer() {
        return damageTimer;
    }

    public void heal() {
        Actor soulHealth = getOneIntersectingObject(Health.class);
        if (soulHealth != null) {
            totalHealth = totalHealth + 5;
            getWorld().removeObject(soulHealth);
        }
    }

    public void statBoosters()
    {
        Actor soulTough = getOneIntersectingObject(ToughSoul.class);
        Actor soulSpeedy = getOneIntersectingObject(SpeedySoul.class);
        Actor soulTanky = getOneIntersectingObject(TankySoul.class);
        Actor soulOP = getOneIntersectingObject(OPSoul.class);
        if (soulTough != null) {
            statsBooster = "ToughSoul";
            getWorld().removeObjects(getWorld().getObjects(ToughSoul.class));
        }
        if (soulSpeedy != null) {
            statsBooster = "SpeedySoul";
            getWorld().removeObjects(getWorld().getObjects(SpeedySoul.class));
        }
        if (soulTanky != null) {
            statsBooster = "TankySoul";
            getWorld().removeObjects(getWorld().getObjects(TankySoul.class));
        }
        if (soulOP != null) {
            statsBooster = "OPSoul";
            getWorld().removeObjects(getWorld().getObjects(OPSoul.class));
        }
    }

    public void useStatBoosters()
    {
        if (statsBooster == "ToughSoul") {
            bonusDamage = 4;
        } else if (statsBooster != "ToughSoul" && statsBooster != "OPSoul") {
            bonusDamage = 0;
        }
        if (statsBooster == "SpeedySoul") {
            speed = 4;
        } else if (statsBooster != "SpeedySoul" && statsBooster != "OPSoul"){
            speed = 2;
        }
        if (statsBooster == "TankySoul") {
            bonusHealth = 12;
            bonusDefense = 2;
        } else if (statsBooster != "TankySoul" && statsBooster != "OPSoul") {
            bonusHealth = 0;
            bonusDefense = 0;
        }
        if (statsBooster == "OPSoul") {
            bonusHealth = 6;
            bonusDamage = 2;
            speed = 3;
            bonusDefense = 1;
        } else if (statsBooster != "ToughSoul" && statsBooster != "SpeedySoul" && statsBooster != "TankySoul" && statsBooster != "OPSoul") {
            bonusHealth = 0;
            bonusDamage = 0;
            speed = 2;
            bonusDefense = 0;
        }
    }

    public void holyItems()
    {
        Actor soulFeather = getOneIntersectingObject(AngelFeather.class);
        Actor soulSalt = getOneIntersectingObject(Salt.class);
        Actor soulVampire = getOneIntersectingObject(VampiricCape.class);
        Actor soulPendant = getOneIntersectingObject(SatanicPendant.class);
        if (soulFeather != null) {
            holyItem = "AngelFeather";
            getWorld().removeObjects(getWorld().getObjects(AngelFeather.class));
        }
        if (soulSalt != null) {
            holyItem = "Salt";
            getWorld().removeObjects(getWorld().getObjects(Salt.class));
        }
        if (soulVampire != null) {
            holyItem = "VampiricCape";
            getWorld().removeObjects(getWorld().getObjects(VampiricCape.class));
        }
        if (soulPendant != null) {
            holyItem = "SatanicPendant";
            getWorld().removeObjects(getWorld().getObjects(SatanicPendant.class));
        }
    }

    public String getHolyItem() {
        return holyItem;
    }

    /**
     * Next Rooms
     */

    public void nextLevel()
    {
        if (getWorld().getObjects(Soul.class) != null)
        {
            if (isTouching(DoorUp.class) || isTouching(DoorLeft.class) || isTouching(DoorRight.class))
            {
                if (getWorld().getObjects(Monsters.class).size() == 0){
                    if (worldChecker == 1){
                        World room2 = new Room2();
                        room2.addObject(this, 10, 200);
                        Greenfoot.setWorld(room2);
                        worldChecker += 1;
                    }
                    else if (worldChecker == 2){
                        World room3 = new Room3();
                        room3.addObject(this, 10, 200);
                        Greenfoot.setWorld(room3);
                        worldChecker += 1;
                    }
                    else if (worldChecker == 3){
                        World room4 = new Room4();
                        room4.addObject(this, 10, 200);
                        Greenfoot.setWorld(room4);
                        worldChecker += 1;
                    }
                }
            }
        }
    }

    public void weapons()
    {
        Actor soulSoulSpear = getOneIntersectingObject(SoulSpear.class);
        Actor soulDemonSpear = getOneIntersectingObject(DemonSpear.class);
        Actor soulClaws = getOneIntersectingObject(BeastsClaws.class);
        Actor soulLight = getOneIntersectingObject(Light.class);
        Actor soulCandle = getOneIntersectingObject(Candle.class);
        Actor soulTears = getOneIntersectingObject(SoulTears.class);
        if (soulSoulSpear != null) {
            weapon = "SoulSpear";
        }
        if (soulDemonSpear != null) {
            weapon = "DemonSpear";
        }
        if (soulClaws != null) {
            weapon = "BeastsClaws";
        }
        if (soulLight != null) {
            weapon = "Light";
        }
        if (soulCandle != null) {
            weapon = "Candle";
        }
        if (soulTears != null) {
            weapon = "SoulTears";
        }
    }

    public void useWeapons()
    {
        SoulSpear holdingSoulSpear = new SoulSpear();
        DemonSpear holdingDemonSpear = new DemonSpear();
        BeastsClaws holdingClaws = new BeastsClaws();
        Light holdingLight = new Light();
        Candle holdingCandle = new Candle();
        SoulTears holdingTears = new SoulTears();
        Actor soulSoulSpear = getOneIntersectingObject(SoulSpear.class);
        Actor soulDemonSpear = getOneIntersectingObject(DemonSpear.class);
        Actor soulClaws = getOneIntersectingObject(BeastsClaws.class);
        Actor soulLight = getOneIntersectingObject(Light.class);
        Actor soulCandle = getOneIntersectingObject(Candle.class);
        Actor soulTears = getOneIntersectingObject(SoulTears.class);
        if (weapon == "SoulSpear") {
            List soulSpearInWorld = getWorld().getObjects(SoulSpear.class);
            if (Greenfoot.isKeyDown("space")) {
                if (soulSpearInWorld.size() == 0) {
                    getWorld().addObject(holdingSoulSpear, getX() + 25, getY());
                }
                weaponHolder = false;
            }
            if (weaponTimer > 0) {
                weaponTimer = weaponTimer - 1;
            }
            if (weaponTimer == 0) {
                getWorld().removeObjects(soulSpearInWorld);
                weaponTimer = 30;
                weaponHolder = true;
            }
        } else {
            getWorld().removeObject(soulSoulSpear);
        }
        if (weapon == "DemonSpear") {
            List demonSpearInWorld = getWorld().getObjects(DemonSpear.class);
            if (Greenfoot.isKeyDown("space")) {
                if (demonSpearInWorld.size() == 0) {
                    getWorld().addObject(holdingDemonSpear, getX() + 25, getY());
                }
                weaponHolder = false;
            }
            if (weaponTimer > 0) {
                weaponTimer = weaponTimer - 1;
            }
            if (weaponTimer == 0) {
                getWorld().removeObjects(demonSpearInWorld);
                weaponTimer = 30;
                weaponHolder = true;
            }
        } else {
            getWorld().removeObject(soulDemonSpear);
        }
        if (weapon == "BeastsClaws") {
            List beastsclawsInWorld = getWorld().getObjects(BeastsClaws.class);
            if (Greenfoot.isKeyDown("space")) {
                if (beastsclawsInWorld.size() == 0) {
                    getWorld().addObject(holdingClaws, getX() + 25, getY());
                }
                weaponHolder = false;
            }
            if (weaponTimer > 0) {
                weaponTimer = weaponTimer - 1;
            }
            if (weaponTimer == 0) {
                getWorld().removeObjects(beastsclawsInWorld);
                weaponTimer = 30;
                weaponHolder = true;
            }
        } else {
            getWorld().removeObject(soulClaws);
        }
        if (weapon == "Light") {
            List lightInWorld = getWorld().getObjects(Light.class);
            if (Greenfoot.isKeyDown("space")) {
                if (lightInWorld.size() == 0) {
                    getWorld().addObject(holdingLight, getX() + 25, getY());
                }
                weaponHolder = false;
            }
            if (weaponTimer > 0) {
                weaponTimer = weaponTimer - 1;
            }
            if (weaponTimer == 0) {
                getWorld().removeObjects(lightInWorld);
                weaponTimer = 30;
                weaponHolder = true;
            }
        } else {
            getWorld().removeObject(soulLight);
        }
        if (weapon == "Candle") {
            List candleInWorld = getWorld().getObjects(Candle.class);
            if (Greenfoot.isKeyDown("space")) {
                if (candleInWorld.size() == 0) {
                    getWorld().addObject(holdingCandle, getX() + 25, getY());
                }
                weaponHolder = false;
            }
            if (weaponTimer > 0) {
                weaponTimer = weaponTimer - 1;
            }
            if (weaponTimer == 0) {
                getWorld().removeObjects(candleInWorld);
                weaponTimer = 30;
                weaponHolder = true;
            }
        } else {
            getWorld().removeObject(soulCandle);
        }
        if (weapon == "SoulTears") {
            List soulTearsInWorld = getWorld().getObjects(SoulTears.class);
            if (Greenfoot.isKeyDown("space")) {
                if (soulTearsInWorld.size() == 0) {
                    getWorld().addObject(holdingTears, getX() + 25, getY());
                }
                weaponHolder = false;
            }
            if (weaponTimer > 0) {
                weaponTimer = weaponTimer - 1;
            }
            if (weaponTimer == 0) {
                getWorld().removeObjects(soulTearsInWorld);
                weaponTimer = 30;
                weaponHolder = true;
            }
        } else {
            getWorld().removeObject(soulTears);
        }
    }

    public void experience()
    {
        if (WDKillCount > WDKillCountHold) {
            expNum += 15;
            WDKillCountHold++;
        }
        if (LDKillCount > LDKillCountHold) {
            expNum += 30;
            LDKillCountHold++;
        }
        if (SHKillCount > LDKillCountHold) {
            expNum += 20;
            LDKillCountHold++;
        }
        if (HKillCount > HKillCountHold) {
            expNum += 35;
            HKillCountHold++;
        }
        if (SSKillCount > SSKillCountHold) {
            expNum += 25;
            SSKillCountHold++;
        }
        if (WSKillCount > WSKillCountHold) {
            expNum += 40;
            WSKillCountHold++;
        }
    }

    public void levelUp()
    {
        if(expNum == 100)
        {
            level += 1;
            expNum = 0;
        }
        if(level == 1 && expNum == 150)
        {
            level += 1;
            expNum = 0;
        }
        if(level == 2 && expNum == 200)
        {
            level += 1;
            expNum = 0;
        }
        if(level == 3 && expNum == 250)
        {
            level += 1;
            expNum = 0;
        }
        if(level == 4 && expNum == 300)
        {
            level += 1;
            expNum = 0;
        }
    }
}