package FireEmblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseListener implements ActionListener
{
    Tile tile;
    World world;
    public MouseListener( Tile tile, World world )
    {
        this.world = world;
        this.tile = tile;
        System.out.println( "Made Clicker listener @" + tile.getX() + ", " + tile.getY() );
    }
    @Override
    public void actionPerformed( ActionEvent e )
    {
        System.out.println( "Tile clicked at" + tile.getX() + ", " + tile.getY() );
        world.moveHero( tile.getX(), tile.getY(), tile.getOccupied() );
    }

}
