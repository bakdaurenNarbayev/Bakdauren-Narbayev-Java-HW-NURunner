
public class HomeworkFactory extends AssessmentFactory {
    public HomeworkFactory( Common common ) {
        super( common );
    }
    
    @Override
    public Assessment createAssessment( Vector2D position ) {
        return new Homework( common, position );
    }  
}
