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
        System.out.println( "Hello, World! Oh boi" );
        
        World world = new World();
        BorderLayout layout = new BorderLayout();
        JFrame frame = new JFrame();
        frame.setSize( 6 * 100 + 6, 8 * 100 + 28 );
        frame.setLayout( layout );
        frame.add( world.dis, BorderLayout.CENTER );

        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setResizable( false );
    }
}
