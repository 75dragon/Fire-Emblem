/**
 * My attempt to copy the fire emblem heros game
 *
 * @author Austin Cheng
 * @version Feb 17, 2017
 * @author Period: -1
 * @author Assignment: FireEmblem
 *
 * @author Sources: Fire Emblem Heros
 */
package FireEmblem;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main
{
    public static void main( String[] args )
    {
        int x = 7; // width of map
        int y = 7; // height of map
        World world = new World(x, y);
        BorderLayout layout = new BorderLayout();
        JFrame frame = new JFrame();
        frame.setSize( x * 100 + 6, y * 100 + 28 );
        frame.setLayout( layout );
        frame.add( world.dis, BorderLayout.CENTER );

        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setResizable( false );
    }
}
