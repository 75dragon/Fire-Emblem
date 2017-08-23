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

    /**
     * Generates a map of tiles to host our playing field
     * @param x dimension of the world
     * @param y dimension of the world
     * @param world that hosts everything
     */
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

    /**
     * to generate random tiles for a random map
     * @param x location of the tile
     * @param y location of the tile
     * @param world the world the tiles are in
     * @return a tile to place in the world
     */
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

    /**
     * using recursion, we need to check that our randomly generated map allows horses to access all squares
     * @param tiles the array of randomly generated tiles
     * @param x current x location
     * @param y current y location
     * @return the number of grass tiles horses can locate. Should be equal to the number of grass tiles
     */
    public int checkMap( Tile[][] tiles, int x, int y )
    {
        //System.out.println( "Check tile at " + x + " " + y );
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

    /**
     * FloodFill to determine where you can go during your turn. 
     * Uses recursion
     * @param x location
     * @param y location
     * @param spaces how many spaces from the original location is
     * @param spd the origional chars speed - our ending case is when spaces > spd
     * @param type the type of the hero - to determine movement for difficult terrain
     */
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
        if ( this.tiles[x][y].tintedBlue == false )
        {
            this.tiles[x][y].tintBlue();
        }
    }

    /**
     * Clears the accessible squares and the tints. To refresh after moving someone.
     */
    public void clearMoves()
    {
        for ( int i = 0; i < x; i++ )
        {
            for ( int ii = 0; ii < y; ii++ )
            {
                this.tiles[i][ii].setReachable( false );
                if ( this.tiles[i][ii].tintedBlue == true )
                {
                    this.tiles[i][ii].untintBlue();
                }
                if ( this.tiles[i][ii].tintedRed == true )
                {
                    this.tiles[i][ii].untintRed();
                }
            }
        }
    }
    
    /**
     * Tints the squares you can attack in red
     * @param xloc x location of hero
     * @param yloc y location of hero
     * @param range the range of the weapon
     */
    public void attackTint(int xloc, int yloc, int range)
    {
        for ( int i = 0; i < x; i++ )
        {
            for ( int ii = 0; ii < y; ii++ )
            {
                if (World.distance( xloc, i ) + World.distance( ii, yloc ) <= range)
                {
                    this.tiles[i][ii].tintRed();
                }
            }
        }
    }
    
    /**
     * Simply repaints all the tiles. Call this after any movement
     */
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
    
    /**
     * returns the array of tiles
     * @return the array of tiles
     */
    public Tile[][] getTiles()
    {
        return tiles;
    }

    /**
     * returns a single tile
     * @param x location
     * @param y location
     * @return a tile
     */
    public Tile getTile( int x, int y )
    {
        return tiles[x][y];
    }
}
