package osrm_interface;

import minimal_json.JsonObject;

public class RouteLeg {

	public final double distance;
	public final double duration;
	public final String summary;
	public final RouteStep[] steps;
	
	public final Annotation annotation;
	
	public RouteLeg(JsonObject jsonLeg) {
		
		distance = jsonLeg.getDouble("distance", -1);
		duration = jsonLeg.getDouble("duration", -1);
		summary = jsonLeg.getString("summary", "");
		
		if(jsonLeg.get("annotation") != null)
			annotation = new Annotation(jsonLeg.get("annotation").asObject());
		else
			annotation = null;
		
		RouteStep[] inSteps = new RouteStep[jsonLeg.get("steps").asArray().size()];
		
		for(int i = 0; i < inSteps.length; i++)
			inSteps[i] = new RouteStep(jsonLeg.get("steps").asArray().get(i).asObject());
		
		steps = inSteps;
		
	}
	
}
