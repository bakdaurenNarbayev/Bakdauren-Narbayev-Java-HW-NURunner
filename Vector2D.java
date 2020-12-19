
public class Vector2D {
    public double x;
    public double y;
    
    public Vector2D() {
        x = 0;
        y = 0;
    }
    
    public Vector2D( Common common ) {
        x = ( int ) common.randomInt( 0, common.windowWidth );
        y = ( int ) common.randomInt( 0, common.windowHeight );
    }
    
    public void set( Vector2D v ) {
        x = v.x;
        y = v.x;
    }
    
    public double distanceTo( Vector2D other ) {
        return( Math.sqrt( Math.pow( x - other.x, 2 ) + Math.pow( y - other.y , 2 ) ) );
    }
    
    public Vector2D normalize() {
        Vector2D result = new Vector2D();
        if( Math.pow( x, 2 ) + Math.pow( y, 2 ) < 1 ) {
            result.x = 10 * result.x;
            result.y = 10 * result.y;
            result.set( result.normalize() );
            return result;
        }
        else {
            result.x = x / Math.sqrt( Math.pow( x, 2 ) + Math.pow( y, 2 ) );
            result.y = y / Math.sqrt( Math.pow( x, 2 ) + Math.pow( y, 2 ) );
            return result;
        }
    }
    
    public Vector2D plus( Vector2D other ) {
        Vector2D result = new Vector2D();
        result.x = x + other.x;
        result.y = y + other.y;
        return result;
    }
    
    public Vector2D minus( Vector2D other ) {
        Vector2D result = new Vector2D();
        result.x = x - other.x;
        result.y = y - other.y;
        return result;
    }
}