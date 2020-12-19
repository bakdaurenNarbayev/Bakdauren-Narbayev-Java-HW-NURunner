
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;


public class Quiz extends Assessment {
    public Quiz( Common common, Vector2D position ) {
        super( common, position );
        points = common.randomInt( 3, 5 );
    }

    @Override
    public void draw( Graphics2D g2d ) {
        Font fOriginal = g2d.getFont();
        FontMetrics fm = g2d.getFontMetrics();
        AffineTransform tOriginal = g2d.getTransform();
        String str;

        g2d.setFont( new Font( "Sans Serif", Font.BOLD, 14 ) );

        g2d.translate( ( int ) position.x, ( int ) position.y );

        g2d.setPaint( Color.BLUE );
        int[] arg0 = { 0, - 12, 12 };
        int[] arg1 = { - 8, 16, 16 };
        g2d.fillPolygon( arg0, arg1, 3 );

        g2d.setPaint( Color.BLACK );
        g2d.drawPolygon( arg0, arg1, 3 );

        str = points + "";
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str , ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 1, 10 );

        g2d.setTransform( tOriginal );
        g2d.setFont ( fOriginal );
    }

    @Override
    public void step() {}
}
