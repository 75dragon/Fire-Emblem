package FireEmblem;

import java.util.Random;

public class Map
{
    public Map(int x, int y)
    {
        Tile[][] tiles = new Tile[x][y];
        
        for(int i = 0; i < x; i++)
        {
            tiles[x][y] = randomTile();
        }
    }
    
    public Tile randomTile()
    {
        Tile hold = null;
        Random rand = new Random();
        int r = rand.nextInt(10) + 1;
        if (r <= 7)
        {
            hold = new Tile("grass");
        }
        else if ( r <= 9 )
        {
            hold = new Tile("forest");
        }
        else
        {
            hold =  new Tile("mountain");
        }
        return hold;
    }
}
