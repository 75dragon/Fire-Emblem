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
    boolean tintedBlue = false;
    boolean tintedRed = false;
    
    /**
     * Makes a tile for the world
     * @param type forest, mountain, grass
     * @param x x location
     * @param y y location
     * @param world the world its in
     */
    public Tile(String type, int x, int y, World world)
    {
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
        //g.drawString( filled?"True" + xloc:"False" + xloc, 0, 20);
        //g.drawString( reachable?"True" + yloc:"false" + yloc, 0, 40 );
        if (occupied != null)
        {
            g.setColor( Color.RED );
            g.setFont(new Font("TimesRoman", Font.BOLD, 25)); 
            g.drawString( occupied.getName(), 10, 50 );
            g.setFont(new Font("TimesRoman", Font.BOLD, 15)); 
            g.drawString( "HP: " + occupied.getHp() + "/" + occupied.getMaxHp(), 10, 75 );
        }
    }
    
    /**
     * returns the tile type: grass, forest, mountain 
     * @return a string
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * returns a hero if it occupies this square, else null
     * @return hero/null
     */
    public Hero getOccupied()
    {
        return occupied;
    }

    /**
     * sets a hero to this square
     * @param occupied a hero
     */
    public void setOccupied( Hero occupied )
    {
        this.occupied = occupied;
    }

    /**
     * used for the floodfill to make sure all tiles are accessible
     * @return boolean, if reachable or not
     */
    public boolean isFilled()
    {
        return filled;
    }

    /**
     * used for the floodfill to mark that the tile is reachable
     * @param filled true, to mark that we can get there
     */
    public void setFilled( boolean filled )
    {
        this.filled = filled;
    }

    /**
     * if the player can access the tile this turn
     * @return boolean, if reachable or not
     */
    public boolean isReachable()
    {
        return reachable;
    }

    /**
     * set if the tile is accessable by a char
     * @param reachable true, to mark that we can get there
     */
    public void setReachable( boolean reachable )
    {
        this.reachable = reachable;
    }
    
    /**
     * gets the X cord
     * @return int X
     */
    public int getxloc()
    {
        return xloc;
    }
    
    /**
     * returns the Y cord
     * @return int Y
     */
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
        tintedBlue = true;
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
        tintedBlue = false;
    }
    
    /**
     * tints the color of the tile red
     */
    public void tintRed()
    {
        System.out.println( "tinting" );
        bl = bl - 50;
        grn = grn - 50;
        color = new Color(rd, grn, bl);
        tintedRed = true;
    }
    
    /**
     * untints the color of the tile red
     */
    public void untintRed()
    {
        bl = bl + 50;
        grn = grn + 50;
        color = new Color(rd, grn, bl);
        tintedRed = false;
    }
}
