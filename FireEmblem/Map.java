package FireEmblem;

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


    public Map( int x, int y )
    {
        System.out.println( "Making map of " + x + " by " + y );
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
                    this.tiles[i][ii] = randomTile( i, ii );
                }
            }
            if ( grassTotal == checkMap( this.tiles, FGX, FGY ) )
            {
                doesntPass = false;
            }
            grassTotal = 0;
            System.out.println( "EACH OF THESE MSSG = 1 TRY BOI" );
        }
    }


    public Tile randomTile( int x, int y )
    {
        Tile hold = null;
        int r = rand.nextInt( 10 ) + 1;
        if ( r <= 7 )
        {
            hold = new Tile( "grass", x, y );
            if ( grassTotal == 0 )
            {
                FGX = x;
                FGY = y;
            }
            grassTotal++;
        }
        else if ( r <= 9 )
        {
            hold = new Tile( "forest", x, y );
        }
        else
        {
            hold = new Tile( "mountain", x, y );
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


    public Tile[][] getTiles()
    {
        return tiles;
    }


    public Tile getTile( int x, int y )
    {
        return tiles[x][y];
    }


    public int getX()
    {
        return x;
    }


    public int getY()
    {
        return y;
    }
}
