package FireEmblem;

import java.util.ArrayList;

    public class World
    {
    public World()
    {
        Hero Merric = new Hero("Merric", 0, 0, 47, 26, 32, 24, 22, "I", "Excalibur");
        Merric.printStats();
        Hero Robin = new Hero("Robin", 0, 0, 40, 29, 29, 29, 22, "I", "Blarraven+");
        Robin.printStats();
        Hero TikiY = new Hero("TikiY", 0, 0, 41, 31, 30, 32, 29, "ID", "Flametoungue+");
        TikiY.printStats();
        Hero Ryoma = new Hero("Ryoma", 0, 0, 41, 34, 35, 27, 21, "I", "Raijinto");
        Ryoma.printStats();
        Hero Raven = new Hero("Raven", 0, 0, 41, 31, 38, 25, 22, "I","Brave Axe+");
        Raven.printStats();
        
        ArrayList<Hero> Heros = new ArrayList<Hero>();
        Heros.add( Merric );
        Heros.add( Robin );
        Heros.add( TikiY );
        Heros.add( Ryoma );
        Heros.add( Raven );
        
        combat(Heros.get( 0 ), Heros.get( 1 ));
        combat(Heros.get( 2 ), Heros.get( 3 ));
        combat(Heros.get( 4 ), Heros.get( 0 ));
        
    }


    public void combat( Hero a, Hero b )
    {
        System.out.println( a.getName() + " is initiating an attack on " + b.getName() );
        double aMod = 1;
        double bMod = 1;
        //weapon triangle, the super effective deals an extra 20% and takes 20% reduced.
        if (a.getWeapon().getColor() == 'B' && b.getWeapon().getColor() == 'R' || 
                        a.getWeapon().getColor() == 'R' && b.getWeapon().getColor() == 'G' ||
                        a.getWeapon().getColor() == 'G' && b.getWeapon().getColor() == 'B' )
        {
            aMod = aMod + .2;
            bMod = bMod - .2;
        }
        
        if (a.getWeapon().getColor() == 'R' && b.getWeapon().getColor() == 'B' || 
                        a.getWeapon().getColor() == 'G' && b.getWeapon().getColor() == 'R' ||
                        a.getWeapon().getColor() == 'B' && b.getWeapon().getColor() == 'G' )
        {
            aMod = aMod - .2;
            bMod = bMod + .2;
        }
        
        //TODO implement killers    
        
        System.out.println( "   " + a.getName() + " is attacking " + b.getName() );
        b.takeDamage( (int)Math.ceil( a.getAtk() * aMod - (a.getWeapon().isPhysical()?b.getDef():b.getRes())) );
        if (a.isAlive() && b.getWeapon().getRange() == a.getWeapon().getRange())
        {
            System.out.println(  "   " + b.getName() + " is attacking " + a.getName() );
            a.takeDamage( (int)Math.ceil( b.getAtk() * bMod - (b.getWeapon().isPhysical()?a.getDef():a.getRes())) );
        }
        if (b.isAlive() && a.isAlive() && a.getSpd() >= b.getSpd() + 5)
        {
            System.out.println(  "   " + a.getName() + " is attacking " + b.getName() );
            b.takeDamage( (int)Math.ceil( a.getAtk() * aMod - (a.getWeapon().isPhysical()?b.getDef():b.getRes())) );
        }       
        if (a.isAlive() && b.isAlive() && b.getWeapon().getRange() == a.getWeapon().getRange() && b.getSpd() >= a.getSpd() + 5)
        {
            System.out.println(  "   " + b.getName() + " is attacking " + a.getName() );
            a.takeDamage( (int)Math.ceil( b.getAtk() * bMod - (b.getWeapon().isPhysical()?a.getDef():a.getRes())) );
        }
        
    }
}
