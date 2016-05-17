package osrm_interface;

public class Route {

	public final double distance;
	public final double duration;
	public final String geometry;
	public final RouteLeg[] legs;
	
	public final double confidence;
	
	public Route(double inDistance, double inDuration, String inGeometry, RouteLeg[] inLegs) {
		
		distance = inDistance;
		duration = inDuration;
		geometry = inGeometry;
		legs = inLegs;
		
		confidence = -1;
		
	}
	
	public Route(double inDistance, double inDuration, String inGeometry, RouteLeg[] inLegs, double inConfidence) {
		
		distance = inDistance;
		duration = inDuration;
		geometry = inGeometry;
		legs = inLegs;
		
		confidence = inConfidence;
		
	}
}
