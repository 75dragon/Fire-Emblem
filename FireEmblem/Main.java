/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author austi
 * @version Feb 17, 2017
 * @author Period: TODO
 * @author Assignment: FireEmblem
 *
 * @author Sources: TODO
 */
package FireEmblem;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main
{
    public static void main( String[] args )
    {
        int x = 10; // width of map
        int y = 10; // height of map
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
