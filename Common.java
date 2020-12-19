
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Common {
    public int windowWidth;
    public int windowHeight;
    public UniversityMap map;
    public List<Academician> academicians;
    public List<Speaker> speakers;
    public List<Student> students;
    public List<Assessment> assessments;
    private final Random random = new Random();
    private final Vector2D STELLA = new Vector2D();
    private int graduatedStudents = 0;
    
    
    public Common() {
        windowWidth = 800;
        windowHeight = 400;
        map = new UniversityMap( this );
        STELLA.x = 565;
        STELLA.y = 325;
        
        academicians = new ArrayList<>();
        academicians.add( new Academician( "Shigeo", "Katsu", this ) );
        academicians.add( new Academician( "Vassilios", "Tourassis", this ) );
        academicians.add( new Academician( "HansDe", "Nivelle", this ) );
        academicians.add( new Academician( "Selim", "Temizer", this ) );
        
        speakers = new ArrayList<>();
        speakers.add( new Speaker( "KassymJomart", "Tokayev", this ) );
        speakers.add( new Speaker( "Nursultan", "Nazarbayev", this ) );
        
        students = new ArrayList<>();
        for( int i = 0; i < 10; i++ ) {
            students.add( new Student( this ) );
        }
        
        assessments = new ArrayList<>();
    }
    
    public int randomInt( int from, int to ) {
        return ( from + random.nextInt( to - from + 1 ) );
    }
    
    public void stepAllEntities() {
        synchronized( students ) {
            for( Student s : students ) {
                s.step();
                
                if( s.grade < 100 ) {
                    synchronized( assessments ) {
                        for( int i = assessments.size() - 1; i >= 0; i-- ) {
                            Assessment a = assessments.get( i ) ;
                            if( s.position.distanceTo( a.position ) <= 10 ) {
                                s.grade += a.points;
                                assessments.remove( i );
                            }
                        }
                    }
                    
                    if( s.state.isOver )
                        s.state = randomStateStudent();
                } else {
                    if ( s.position.distanceTo( STELLA ) <= 25 )
                        s.state = new Stationary();
                    else {
                        GotoXY gotoSTELLA = new GotoXY( this );
                        Vector2D v = new Vector2D();
                        v.x = this.randomInt( 1, 10 );
                        v.y = this.randomInt( 1, 10 );
                        gotoSTELLA.destination = STELLA.plus( v );
                        s.state =  gotoSTELLA;
                    }
                    graduatedStudents++;
                }
            }
        }
        
            for( int i = 0; i < 4; i++ ) {
                Academician a = academicians.get( i );
                if( graduatedStudents >= 10 ) {
                    a.assessmentAccess = false;
                    a.position.x = STELLA.x - 105 + 70 * i;
                    a.position.y = STELLA.y - 85;
                    a.state = new Stationary();
                } else {
                    if( !a.state.isOver )
                        a.step();
                    else
                        a.state = randomStateAcademician( a );
                }
            }
        
        for( Assessment a: assessments ) {
            a.step();
        }
    }
    
    public void drawAllEntities( Graphics2D g2d ) {
        map.draw( g2d );
        
        for( Academician a: academicians ) {
            a.draw( g2d );
        }
        for( Student s: students ) {
            s.draw( g2d );
        }
        
        synchronized( assessments ) {
            for( Assessment a: assessments ) {
                a.draw( g2d );
            }
        }
        
        if( graduatedStudents == 10 ) {
            Vector2D v = new Vector2D();
            v.x = - 270;
            for( Speaker s: speakers ) {
                v.x = v.x + 180;
                s.position = STELLA.plus( v );
                s.draw( g2d );
                drawGraduation( g2d );
            }
            synchronized( assessments ) {
                for ( int i = assessments.size() - 1; i >= 0; i-- ) {
                    assessments.remove( i );
                }
            }
        }
                
        graduatedStudents = 0;
    }
    
    public State randomStateStudent() {
        int i = this.randomInt( 0, 3 );
        switch ( i ) {
            case 0:
                return new Rest( this );
            case 1:
                return new GotoXY( this );
            case 2:
                return new ZigZag( this );
            default:
                return new Closest( this );
        }
    }
    
    public State randomStateAcademician( Academician a ) {
        int i = this.randomInt( 0, 2 );
        switch ( i ) {
            case 0:
                a.assessmentAccess = false;
                return new Rest( this );
            case 1:
                a.assessmentAccess = true;
                return new GotoXY( this );
            default:
                a.assessmentAccess = true;
                return new ZigZag( this );
        }
    }
    
    private void drawGraduation( Graphics2D g2d ) {  
        Font fOriginal = g2d.getFont();
        FontMetrics fm = g2d.getFontMetrics();
        AffineTransform tOriginal = g2d.getTransform();
        String str;

        g2d.setFont( new Font( "Sans Serif", Font.BOLD, 14 ) );

        g2d.translate( ( int ) STELLA.x, ( int ) STELLA.y );

        str = "Graduation Ceremony";
        g2d.setPaint( Color.BLACK );
        g2d.drawString( str, ( int ) ( - fm.stringWidth( str ) / 2.0 ) - 15, 55 );

        g2d.setTransform( tOriginal );
        g2d.setFont ( fOriginal );
    }
}
