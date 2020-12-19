
public class QuizFactory extends AssessmentFactory {
    public QuizFactory( Common common ) {
        super( common );
    }
    
    @Override
    public Assessment createAssessment( Vector2D position ) {
        return new Quiz( common, position );
    }   
}
