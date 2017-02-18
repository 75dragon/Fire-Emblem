package FireEmblem;

import java.awt.Color;
import java.awt.Graphics;

public class Tile
{
    String type;
    Hero occupied;
    int x;
    int y;
    Color color;
    boolean filled = false;
    
    public Tile(String type, int x, int y)
    {
        this.type = type;
        System.out.println("Making a " + type + " tile at " + x + " , " + y);
        if (type.equals( "grass" ))
        {
            color = new Color(204, 255, 51);
        }
        if (type.equals( "forest" ))
        {
            color = new Color(0, 153, 0);
        }
        if (type.equals( "mountain" ))
        {
            color = Color.GRAY;
        }
        this.x = x;
        this.y = y;
    }
    
    public void draw( Graphics g )
    {
        g.setColor(color);
        g.fillRect( x * 100, y * 100, 100, 100 );
        g.setColor( Color.BLACK );
        g.drawString( filled?"True":"False", x * 100, y * 100 + 20);
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
    
}
