package FireEmblem;

public class Weapon
{
    int range = 0;

    int weaponAtk = 0;

    boolean brave = false;// fk Raven

    String killer = "N";// fk Merric

    String adv = "N";// fk Robin

    boolean counter = false;// fk lobster

    String color = "";

    String name = "";

    boolean physical;

    Hero hero;


    public Weapon( String name, Hero hero )
    {
        this.name = name;
        this.hero = hero;
        if ( name.equals( "Excalibur" ) )
        {
            range = 2;
            weaponAtk = 14;
            killer = "F";
            physical = false;
            color = "G";
        }
        else if ( name.equals( "Blarraven+" ) )
        {
            range = 2;
            weaponAtk = 11;
            adv = "W";
            physical = false;
            color = "B";
        }
        else if ( name.equals( "Flametoungue+" ) )
        {
            range = 1;
            weaponAtk = 15;
            physical = false;
            color = "R";
        }
        else if ( name.equals( "Brave Axe+" ) )
        {
            range = 1;
            weaponAtk = 8;
            brave = true;
            physical = true;
            color = "G";
            hero.setSpdChange( -5 );
        }
        else if ( name.equals( "Raijinto" ) )
        {
            range = 1;
            weaponAtk = 16;
            counter = true;
            physical = true;
            color = "R";
        }
        else if ( name.equals( "Noatun" ) )
        {
            range = 1;
            weaponAtk = 16;
            physical = true;
            color = "G";
        }
        else if ( name.equals( "Fensalir" ) )
        {
            range = 1;
            weaponAtk = 16;
            physical = true;
            color = "B";
        }
        else if ( name.equals( "Folkvangr" ) )
        {
            range = 1;
            weaponAtk = 16;
            physical = true;
            color = "R";
        }

    }


    public int getRange()
    {
        return range;
    }


    public void setRange( int range )
    {
        this.range = range;
    }


    public int atk()
    {
        return weaponAtk;
    }


    public boolean isBrave()
    {
        return brave;
    }


    public String getKiller()
    {
        return killer;
    }


    public String getAdv()
    {
        return adv;
    }


    public boolean isCounter()
    {
        return counter;
    }


    public String getColor()
    {
        return color;
    }


    public String getName()
    {
        return name;
    }


    public boolean isPhysical()
    {
        return physical;
    }
}
