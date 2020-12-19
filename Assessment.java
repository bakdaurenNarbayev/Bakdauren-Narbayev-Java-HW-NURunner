
public abstract class Assessment extends Entity {
    public int points;
    
    public Assessment( Common common, Vector2D position ) {
        super( common );
        this.position = position;
        state = new Stationary();
    }
}
