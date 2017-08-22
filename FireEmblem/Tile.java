package FireEmblem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

public class Tile extends JButton
{
    String type;
    Hero occupied;
    int xloc;
    int yloc;
    int rd;
    int grn;
    int bl;
    Color color;
    boolean filled = false;
    boolean reachable = false;
    World world;
    boolean tinted = false;
    
    public Tile(String type, int x, int y, World world)
    {
        //setOpaque(false);
        //setContentAreaFilled(false);
        //setBorderPainted(false);
        this.type = type;
        System.out.println("Making a " + type + " tile at " + x + " , " + y);
        if (type.equals( "grass" ))
        {
            rd = 204;
            grn = 255;
            bl = 51;
        }
        if (type.equals( "forest" ))
        {
            rd = 50;
            grn = 153;
            bl = 50;
        }
        if (type.equals( "mountain" ))
        {
            rd = 125;
            grn = 125;
            bl = 125;
        }
        color = new Color(rd, grn, bl);
        xloc = x;
        yloc = y;
    }
    
    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        g.setColor(this.color);
        g.fillRect( 0, 0, 100, 100 );
        g.setColor( Color.BLACK );
        g.setFont( new Font("TimesRoman", Font.PLAIN, 15) );
        g.drawString( filled?"True" + xloc:"False" + xloc, 0, 20);
        g.drawString( reachable?"True" + yloc:"false" + yloc, 0, 40 );
        if (occupied != null)
        {
            g.setColor( Color.RED );
            g.setFont(new Font("TimesRoman", Font.BOLD, 25)); 
            g.drawString( occupied.getName(), 10, 50 );
            g.setFont(new Font("TimesRoman", Font.BOLD, 15)); 
            g.drawString( "HP: " + occupied.getHp() + "/" + occupied.getMaxHp(), 10, 75 );
        }
        //System.out.println(this.isVisible() + " " + x + ", " + y + color);
    }
    
    //getter/setter
    public String getType()
    {
        return type;
    }
    
    public Hero getOccupied()
    {
        return occupied;
    }

    public void setOccupied( Hero occupied )
    {
        this.occupied = occupied;
    }

    public boolean isFilled()
    {
        return filled;
    }

    public void setFilled( boolean filled )
    {
        this.filled = filled;
    }

    public boolean isReachable()
    {
        return reachable;
    }

    public void setReachable( boolean reachable )
    {
        this.reachable = reachable;
    }
    
    public int getxloc()
    {
        return xloc;
    }
    
    public int getyloc()
    {
        return yloc;
    }
    
    /**
     * tints the color of the tile blue
     */
    public void tintBlue()
    {
        rd = rd - 50;
        bl = bl + 100;
        grn = grn - 50;
        color = new Color(rd, grn, bl);
        tinted = true;
    }
    
    /**
     * untints the color of the tile blue
     */
    public void untintBlue()
    {
        rd = rd + 50;
        bl = bl - 100;
        grn = grn + 50;
        color = new Color(rd, grn, bl);
        tinted = false;
    }
}
