package FireEmblem;

public class Hero
{
    String name;

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

    public Hero(String name, int x, int y, int hp, int atk, int spd, int def, int res, String classes, String weapon)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.maxHp = hp;
        this.atk = atk;
        this.spd = spd;
        this.def = def;
        this.res = res;
        this.classes = classes;
        this.weapon = new Weapon(weapon, this);
    }

    void takeDamage( int damageTaken )
    {
        if ( damageTaken <= 0 )
        {
            System.out.println(  "   " + name + " has taken 0 damage!" );
            return;
        }
        if ( damageTaken > 0 )
        {
            hp = hp - damageTaken;
            System.out.println(  "   " + name + " has taken " + damageTaken + " damage!" );
        }
        if ( hp < 0 )
        {
            System.out.println(  "   " + name + " has been defeated!" );
            alive = false;
        }
    }

    void printStats()
    {
        System.out.println(name);
        System.out.println("Hp: " +  getHp() + "/" + maxHp);
        System.out.println("Atk: " + getAtk());
        System.out.println("Spd: " + getSpd());
        System.out.println("Def: " + getDef());
        System.out.println("Res: " + getRes());
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

}
