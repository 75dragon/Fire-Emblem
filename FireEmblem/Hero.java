package FireEmblem;

public class Hero
{
    String name; 
    
    //location
    int x;

    int y;

    // all ___Change are debuffs and buffs.
    int maxHp;

    int hp;

    int atk;

    int atkChange = 0;

    int spd;

    int spdChange = 0;

    int def;

    int defChange = 0;

    int res;

    int resChange = 0;

    boolean alive = true;

    String classes;

    Weapon weapon;

    World world;
    
    boolean hasTurn = true;
    
    boolean hasAtk = true;
    
    public Hero( String name, int hp, int atk, int spd, int def, int res, String classes, String weapon, World world)
    {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.atk = atk;
        this.spd = spd;
        this.def = def;
        this.res = res;
        this.classes = classes;
        this.weapon = new Weapon( weapon, this );
        this.world = world;
    }
    
    public boolean SetLocation(int x, int y)
    {
        if(world.map.getTile( x, y ).getOccupied() == null && world.map.getTile( x, y ).getType().equals( "grass" ))
        {
            world.map.getTile( x, y ).setOccupied( this );
            this.x = x;
            this.y = y;
            return true;
        }
        return false;
    }
    
    public boolean moveLocation(int x, int y)
    {
        if (world.map.getTile( x, y ).getOccupied() == null)
        {
            world.map.getTile( this.x, this.y ).setOccupied( null );
            world.map.getTile( x, y ).setOccupied( this );
            this.x = x;
            this.y = y;
            return true;
        }
        return false;
    }

    //takes damageTaken damage. 
    void takeDamage( int damageTaken )
    {
        if ( damageTaken <= 0 )//you cant take negative damage
        {
            System.out.println( "   " + name + " has taken 0 damage!" );
            return;
        }
        if ( damageTaken > 0 )//hits for damageTaken
        {
            hp = hp - damageTaken;
            System.out.println( "   " + name + " has taken " + damageTaken + " damage!" );
        }
        if ( hp < 0 )//you dead boi
        {
            System.out.println( "   " + name + " has been defeated!" );
            alive = false;
        }
    }

    //heals for healValue, cannot exceed maxHp.
    void heal( int healValue )
    {
        hp = hp + healValue;
        if ( hp > maxHp )
        {
            hp = maxHp;
        }
    }

    //prints stats. what else?
    void printStats()
    {
        System.out.println( name );
        System.out.println( "Hp: " + getHp() + "/" + maxHp );
        System.out.println( "Atk: " + getAtk() );
        System.out.println( "Spd: " + getSpd() );
        System.out.println( "Def: " + getDef() );
        System.out.println( "Res: " + getRes() );
    }
    
    // getters/setters

    public String getName()
    {
        return name;
    }


    public int getX()
    {
        return x;
    }


    public void setX( int x )
    {
        this.x = x;
    }


    public int getY()
    {
        return y;
    }


    public void setY( int y )
    {
        this.y = y;
    }


    public int getMaxHp()
    {
        return maxHp;
    }


    public int getHp()
    {
        return hp;
    }


    public void setHp( int hp )
    {
        this.hp = hp;
    }


    public int getAtk()
    {
        return atk + atkChange + weapon.atk();
    }


    public int getAtkChange()
    {
        return atkChange;
    }


    public void setAtkChange( int atkChange )
    {
        this.atkChange = this.atkChange + atkChange;
    }


    public int getSpd()
    {
        return spd + spdChange;
    }


    public int getSpdChange()
    {
        return spdChange;
    }


    public void setSpdChange( int spdChange )
    {
        this.spdChange = this.spdChange + spdChange;
    }


    public int getDef()
    {
        return def + defChange;
    }


    public int getDefChange()
    {
        return defChange;
    }


    public void setDefChange( int defChange )
    {
        this.defChange = this.defChange + defChange;
    }


    public int getRes()
    {
        return res + resChange;
    }


    public int getResChange()
    {
        return resChange;
    }


    public void setResChange( int resChange )
    {
        this.resChange = this.resChange + resChange;
    }


    public boolean isAlive()
    {
        return alive;
    }


    public void setAlive( boolean alive )
    {
        this.alive = alive;
    }


    public String getClasses()
    {
        return classes;
    }


    public Weapon getWeapon()
    {
        return weapon;
    }

    public boolean isHasTurn()
    {
        return hasTurn;
    }

    public void setHasTurn( boolean hasTurn )
    {
        this.hasTurn = hasTurn;
    }

    public boolean isHasAtk()
    {
        return hasAtk;
    }

    public void setHasAtk( boolean hasAtk )
    {
        this.hasAtk = hasAtk;
    }
    
    
}
