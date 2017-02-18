package FireEmblem;

import java.awt.Dimension;
import java.awt.Graphics;

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
    }
    
    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        this.g = g;
        for (int i = 0; i < x; i++ )
        {
            for (int ii = 0; ii < y; ii++)
            {
                map.getTile( i, ii ).draw( g );
            }
        }
    }
}