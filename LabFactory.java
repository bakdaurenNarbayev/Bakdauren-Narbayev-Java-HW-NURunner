
public class LabFactory extends AssessmentFactory {
    public LabFactory( Common common ) {
        super( common );
    }
    
    @Override
    public Assessment createAssessment( Vector2D position ) {
        return new Lab( common, position );
    }   
}
