
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Speaker extends Entity {

    public Speaker( String fname, String sname, Common common ) {
        super( common );
        this.name = fname + " " + sname;
        this.common = common;
        state = new Stationary();
    }

    @Override
    public void draw( Graphics2D g2d ) {    
        Font fOriginal = g2d.getFont();
        FontMetrics fm = g2d.getFontMetrics();
        AffineTransform tOriginal = g2d.getTransform();
        String str;

        g2d.setFont( new Font( "Sans Serif", Font.BOLD, 14 ) );

        g2d.translate( ( int ) position.x, ( int ) position.y );
        
        try {
            BufferedImage img = ImageIO.read( new File( name.replace( " ", "" ) + ".gif" ) );
            double ratio = ( double ) img.getWidth( null ) / ( double ) img.getHeight( null );
            g2d.drawImage( img, - 20, ( int ) ( - 20 / ratio ), 40, ( int ) ( 40 / ratio ), null );
        } catch ( IOException ex ) {
            System.out.println( "No such file exists. " );
        }

        str = name.split( " " )[ 1 ];
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str, ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 7, - 28 );

        g2d.setTransform( tOriginal );
        g2d.setFont ( fOriginal );
    }
    
    @Override
    public void step() {
        state.step(this);
    }   
}
