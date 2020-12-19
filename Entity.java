
import java.awt.Graphics2D;


public abstract class Entity {
    public String name;
    public Vector2D position;
    public State state;
    public Common common;
    
    public Entity( Common common ) {
        this.common = common;
        position = new Vector2D( common );
    }
    
    public abstract void draw( Graphics2D g2d );
    public abstract void step();
}
