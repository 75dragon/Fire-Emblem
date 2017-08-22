package FireEmblem;

import java.awt.event.ActionListener;
import java.util.Random;


public class Map
{
    Tile[][] tiles;

    int x;

    int y;

    Random rand = new Random();

    int FGX = 0;// first grass tile's x

    int FGY = 0;// first grass tile's y

    int grassTotal = 0;

    Tile hold;

    World world;


    public Map( int x, int y, World world )
    {
        System.out.println( "Making map of " + x + " by " + y );
        this.world = world;
        this.x = x;
        this.y = y;
        this.tiles = new Tile[x][y];
        boolean doesntPass = true;
        while ( doesntPass )
        {
            for ( int i = 0; i < x; i++ )
            {
                for ( int ii = 0; ii < y; ii++ )
                {
                    hold = randomTile( i, ii, world );
                    this.tiles[i][ii] = hold;
                    System.out.println( hold.getX() );
                    ActionListener listener = new MouseListener( hold, world );
                    hold.addActionListener( listener );
                    hold.repaint();
                }
            }
            if ( grassTotal == checkMap( this.tiles, FGX, FGY ) )
            {
                doesntPass = false;
            }
            else
            {
                grassTotal = 0;
                this.tiles = new Tile[x][y];
            }
        }
    }


    public Tile randomTile( int x, int y, World world )
    {
        Tile hold = null;
        int r = rand.nextInt( 10 ) + 1;
        if ( r <= 7 )
        {
            hold = new Tile( "grass", x, y, world );
            if ( grassTotal == 0 )
            {
                FGX = x;
                FGY = y;
            }
            grassTotal++;
        }
        else if ( r <= 9 )
        {
            hold = new Tile( "forest", x, y, world );
        }
        else
        {
            hold = new Tile( "mountain", x, y, world );
        }
        return hold;
    }


    public int checkMap( Tile[][] tiles, int x, int y )
    {
        System.out.println( "Check tile at " + x + " " + y );
        if ( x < 0 || x >= this.x || y < 0 || y >= this.y )
        {
            return 0;
        }
        if ( tiles[x][y].isFilled() == true || !tiles[x][y].getType().equals( "grass" ) )
        {
            return 0;
        }
        if ( tiles[x][y].isFilled() == false )
        {
            tiles[x][y].setFilled( true );
            return 1 + checkMap( tiles, x + 1, y ) + checkMap( tiles, x - 1, y ) + checkMap( tiles, x, y + 1 )
                + checkMap( tiles, x, y - 1 );
        }
        else
        {
            return 0;
        }
    }


    public void makeMoves( int x, int y, int spaces, int spd, String type )
    {
        if ( spaces > spd )
        {
            return;
        }
        if ( x < 0 || x >= this.x || y < 0 || y >= this.y )
        {
            return;
        }
        if ( tiles[x][y].getType().equals( "forest" ) && type.contains( "C" ) )
        {
            return;
        }
        if ( tiles[x][y].getType().equals( "mountain" ) && ( type.contains( "C" ) || type.contains( "I" ) ) )
        {
            return;
        }
        if ( type.contains( "F" ) )
        {
            spaces++;
            makeMoves( x + 1, y, spaces, spd, type );
            makeMoves( x - 1, y, spaces, spd, type );
            makeMoves( x, y + 1, spaces, spd, type );
            makeMoves( x, y - 1, spaces, spd, type );
        }
        else if ( type.contains( "I" ) )
        {
            if ( tiles[x][y].getType().equals( "forest" ) )
            {
                spaces++;
            }
            spaces++;
            makeMoves( x + 1, y, spaces, spd, type );
            makeMoves( x - 1, y, spaces, spd, type );
            makeMoves( x, y + 1, spaces, spd, type );
            makeMoves( x, y - 1, spaces, spd, type );
        }
        else
        {
            spaces++;
            makeMoves( x + 1, y, spaces, spd, type );
            makeMoves( x - 1, y, spaces, spd, type );
            makeMoves( x, y + 1, spaces, spd, type );
            makeMoves( x, y - 1, spaces, spd, type );
        }
        this.tiles[x][y].setReachable( true );
        if ( this.tiles[x][y].tinted == false )
        {
            this.tiles[x][y].tintBlue();
        }
    }


    public void clearMoves()
    {
        for ( int i = 0; i < x; i++ )
        {
            for ( int ii = 0; ii < y; ii++ )
            {
                this.tiles[i][ii].setReachable( false );
                if ( this.tiles[i][ii].tinted == true )
                {
                    this.tiles[i][ii].untintBlue();
                }
            }
        }
    }

    public void refreshTiles()
    {
        for ( int i = 0; i < x; i++ )
        {
            for ( int ii = 0; ii < y; ii++ )
            {
                this.tiles[i][ii].repaint();
            }
        }
    }
    
    public Tile[][] getTiles()
    {
        return tiles;
    }


    public Tile getTile( int x, int y )
    {
        return tiles[x][y];
    }
}
