package FireEmblem;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Displayer extends JPanel
{
    Map map;
    int width;
    int x;
    int height;
    int y;
    Graphics g;
    Tile tile;
    Dimension size;
    public Displayer()
    {
        System.out.println( "making displayer" );
    }
    
    public void setMap( Map map)  
    {
        this.map = map;
        x = map.getX();
        width = x * 100;
        y = map.getY();
        height = y * 100;
        size = new Dimension(width, height);
        this.setSize( size );
        this.setLayout( new GridLayout(8,6) );
        for (int i = 0; i < y; i++)
        {
            for (int ii = 0; ii < x; ii++)
            {
                this.add(tile = map.getTile( ii, i ));
                System.out.println( tile.getX() + ", " + tile.getY() + ": " + tile.getType() );
            }
        }
        this.setVisible( true );
    }
    
    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
    }
}