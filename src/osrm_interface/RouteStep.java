package osrm_interface;

import minimal_json.JsonObject;

public class RouteStep {
	
	public final double distance;
	public final double duration;
	public final String geometry;
	public final String name;
	public final String mode;
	public final StepManeuver maneuver;
	public final Intersection[] intersections;
	
	public RouteStep(JsonObject jsonStep) {
		
		distance = jsonStep.getDouble("distance", -1);
		duration = jsonStep.getDouble("duration", -1);
		geometry = jsonStep.getString("geometry", "");
		name = jsonStep.getString("name", "");
		mode = jsonStep.getString("mode", "");
		maneuver = new StepManeuver(jsonStep.get("maneuver").asObject());
		
		Intersection[] inIntersections = new Intersection[jsonStep.get("intersections").asArray().size()];
		
		for(int i = 0; i < inIntersections.length; i++)
			inIntersections[i] = new Intersection(jsonStep.get("intersections").asArray().get(i).asObject());
		
		intersections = inIntersections;
		
	}
	
}
