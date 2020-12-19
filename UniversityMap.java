
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class UniversityMap extends Entity {
    public UniversityMap( Common common ) {
        super( common );
        name = "Nazarbayev University Map";
        position.x = 0;
        position.y = 0;
    }

    @Override
    public void draw( Graphics2D g2d ) {    
        try {
            BufferedImage image = ImageIO.read( new File( "NUMap-Faded.jpg" ) );
            g2d.drawImage( image, ( int ) position.x, ( int ) position.y, null );
        } catch ( IOException ex ) {
            System.out.println( "No such file exists. " );
        }
    }
    
    @Override
    public void step() {}
}
