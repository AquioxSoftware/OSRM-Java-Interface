package osrm_interface;

public class RouteStep {
	
	public final double distance;
	public final double duration;
	public final String geometry;
	public final String name;
	public final String mode;
	public final StepManeuver maneuver;
	
	public RouteStep(double inDistance, double inDuration, String inGeometry, String inName, String inMode,
			StepManeuver inManeuver) {
		
		distance = inDistance;
		duration = inDuration;
		geometry = inGeometry;
		name = inName;
		mode = inMode;
		maneuver = inManeuver;
		
	}
}
