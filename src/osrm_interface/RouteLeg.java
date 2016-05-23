package osrm_interface;

import minimal_json.JsonObject;

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
	
	public RouteLeg(JsonObject jsonLeg) {
		
		distance = jsonLeg.getDouble("distance", -1);
		duration = jsonLeg.getDouble("duration", -1);
		summary = jsonLeg.getString("summary", "");
		annotation = new Annotation(jsonLeg.get("annotation").asObject());
		
		RouteStep[] inSteps = new RouteStep[jsonLeg.get("steps").asArray().size()];
		
		for(int i = 0; i < inSteps.length; i++)
			inSteps[i] = new RouteStep(jsonLeg.get("steps").asArray().get(i).asObject());
		
		steps = inSteps;
		
	}
	
}
