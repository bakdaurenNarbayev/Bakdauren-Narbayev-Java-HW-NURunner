
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;


public class Lab extends Assessment {
    public Lab( Common common, Vector2D position ) {
        super( common, position );
        points = common.randomInt( 2, 4 );
    }

    @Override
    public void draw( Graphics2D g2d ) {
        Font fOriginal = g2d.getFont();
        FontMetrics fm = g2d.getFontMetrics();
        AffineTransform tOriginal = g2d.getTransform();
        String str;

        g2d.setFont( new Font( "Sans Serif", Font.BOLD, 14 ) );

        g2d.translate( ( int ) position.x, ( int ) position.y );

        g2d.setPaint( Color.RED );
        g2d.fillOval( - 10, - 10, 20, 20 );

        g2d.setPaint( Color.BLACK );
        g2d.drawOval( - 10, - 10, 20, 20 );

        str = points + "";
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str , ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 1, 6 );

        g2d.setTransform( tOriginal );
        g2d.setFont ( fOriginal );
    }

    @Override
    public void step() {}
}
