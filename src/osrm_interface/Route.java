package osrm_interface;

import minimal_json.JsonObject;

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
	
	public Route(JsonObject jsonRoute) {
		
		distance = jsonRoute.getDouble("distance", -1);
		duration = jsonRoute.getDouble("duration", -1);
		geometry = jsonRoute.getString("geometry", "");
		confidence = jsonRoute.getDouble("confidence", -1);
		
		RouteLeg[] inLegs = new RouteLeg[jsonRoute.get("legs").asArray().size()];
		
		for(int i = 0; i < inLegs.length; i++)
			inLegs[i] = new RouteLeg(jsonRoute.get("legs").asArray().get(i).asObject());
		
		legs = inLegs;
		
	}
}
