package FireEmblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseListener implements ActionListener
{
    Tile tile;
    public MouseListener( Tile tile )
    {
        this.tile = tile;
        System.out.println( "Made Clicker listener @" + tile.getX() + ", " + tile.getY() );
    }
    @Override
    public void actionPerformed( ActionEvent e )
    {
        System.out.println( "Tile clicked at" + tile.getX() + ", " + tile.getY() );
    }

}
