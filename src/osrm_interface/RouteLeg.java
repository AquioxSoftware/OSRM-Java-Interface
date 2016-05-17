package osrm_interface;

public class RouteLeg {

	public final double distance;
	public final double duration;
	public final String summary;
	public final RouteStep[] steps;
	
	public final Annotation annotation;
	
	public RouteLeg(double inDistance, double inDuration, String inSummary, RouteStep[] inSteps) {
		
		distance = inDistance;
		duration = inDuration;
		summary = inSummary;
		steps = inSteps;
		
		annotation = new Annotation(new double[0], new double[0]);
		
	}
	
	public RouteLeg(double inDistance, double inDuration, String inSummary, RouteStep[] inSteps,
			Annotation inAnnotation) {
		
		distance = inDistance;
		duration = inDuration;
		summary = inSummary;
		steps = inSteps;
		
		annotation = inAnnotation;
		
	}
	
}
