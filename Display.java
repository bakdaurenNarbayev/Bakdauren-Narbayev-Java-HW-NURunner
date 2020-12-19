
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Display extends JPanel {
    public Common common;
    
    public Display( Common common ) {
        super();
        this.common = common;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension( common.windowWidth, common.windowHeight );
    }
    
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        Graphics2D g2d = ( Graphics2D ) g;
        
        common.drawAllEntities( g2d );
    }
}
