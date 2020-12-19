
public class ZigZag extends State {
    private Vector2D direction;
    private final int speed;
    private int numberOfSteps;
    
    public ZigZag( Common common ) {
        super();
        isOver = false;
        direction = new Vector2D( common );
        Vector2D v = new Vector2D( common );
        direction = direction.minus( v );
        speed = common.randomInt( 4, 16  );
        
        if( direction.x == 0 && direction.y == 0 )
            direction.x = 1; 
        direction = direction.normalize();
        direction.x = direction.x * speed;
        direction.y = direction.y * speed;
        numberOfSteps = common.randomInt( 20, 70 );
    }
    
    @Override
    public void step( Entity e ) {
        if( numberOfSteps > 0 ) {
            numberOfSteps--;
            e.position = e.position.plus( direction );
            if( e.position.x < 0 ) {
                direction.x = direction.x * ( - 1 );
                e.position.x = 0;
            }
            if( e.position.x > e.common.windowWidth ) {
                direction.x = direction.x * ( - 1 );
                e.position.x = e.common.windowWidth;
            }
            if( e.position.y < 0 ) {
                direction.y = direction.y * ( - 1 );
                e.position.y = 0;
            }
            if( e.position.y > e.common.windowHeight ) {
                direction.y = direction.y * ( - 1 );
                e.position.y = e.common.windowHeight;
            }
        }
        else
            isOver = true;
    }
}
