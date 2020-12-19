
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class NURunner {
    public JFrame window;
    public Display display;
    public Common common;
    
    public NURunner() {
        common = new Common();
        window = new JFrame( "NURunner by Bakdauren Narbayev" );
        display = new Display( common );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container cp = window.getContentPane();
        cp.setLayout( new FlowLayout() );
        ActionListener listener1 = new ActionListener() {
                                    public void actionPerformed( ActionEvent e ) {
                                        common.stepAllEntities();
                                        window.repaint();
                                    };
                                };
        
        Timer myTimer = new Timer( 100, listener1 );
        
        myTimer.start();
        
        cp.add( display );
        window.pack();
    }
    
    public static void main( String[] args ) {
        NURunner nur = new NURunner();
        JFrame window = nur.window;
        SwingUtilities.invokeLater( new Runnable() {
                                        public void run() {
                                            window.setVisible( true );
                                        }
                                    } 
                                );
    }
}
