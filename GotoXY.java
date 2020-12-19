
public class GotoXY extends State {
    public Vector2D destination;
    private final int speed;
    
    public GotoXY( Common common ) {
        super();
        isOver = false;
        destination = new Vector2D( common );
        speed = common.randomInt( 4, 16  ); 
    }
    
    @Override
    public void step( Entity e ) {
        for( int i = 0; i < speed; i++ ) {
            if( e.position.distanceTo( destination ) >= 10 )
                e.position = e.position.plus( destination.minus( e.position ).normalize() );
            else
                isOver = true;
        }   
    }
}
