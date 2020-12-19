
public class Closest extends State {
    private Vector2D destination;
    private final int speed;
    private int numberOfSteps;
    private Assessment closestAssessment;
    
    public Closest( Common common ) {
        super();
        isOver = false;
        destination = new Vector2D( common );
        speed = common.randomInt( 4, 16  );
        numberOfSteps = common.randomInt( 10, 30 );
        closestAssessment = null;
    }
    
    @Override
    public void step( Entity e ) {
        if( numberOfSteps > 0 ) {
            numberOfSteps--;
            double min = Math.sqrt( Math.pow( e.common.windowHeight, 2 ) + Math.pow( e.common.windowWidth, 2 ) );
            synchronized( e.common.assessments ) {
                for ( int i = e.common.assessments.size() - 1; i >= 0; i-- ) {
                    Assessment a = e.common.assessments.get( i ) ;
                    if ( e.position.distanceTo( a.position ) <= min ) {
                        min = e.position.distanceTo( a.position );
                        closestAssessment = a;
                    }
                }
                if( closestAssessment != null ) {
                    destination = closestAssessment.position;
                    for( int j = 0; j < speed; j++ ) {
                        if( e.position.distanceTo( destination ) >= 10 )
                            e.position = e.position.plus( destination.minus( e.position ).normalize() );
                    }
                }
            }
        }
        else
            isOver = true;
    }
}
