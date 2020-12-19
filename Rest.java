
public class Rest extends State {
    
    private int numberOfSteps;

     public Rest( Common common ) {
        super();
        isOver = false;
        numberOfSteps = common.randomInt( 20, 70 );
    }
    
    @Override
    public void step(Entity e) {
        if( numberOfSteps > 0 )
            numberOfSteps--;
        else
            isOver = true;
    }
    
}
