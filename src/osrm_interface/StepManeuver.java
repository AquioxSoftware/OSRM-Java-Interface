package osrm_interface;

import minimal_json.JsonObject;

public class StepManeuver {
	
	public final LatLng location;
	public final int bearingBefore;
	public final int bearingAfter;
	public final String type;
	
	public final String modifier;
	public final int exit;

	public StepManeuver(JsonObject jsonManeuver) {
		
		if(jsonManeuver.get("waypoint") != null)
			location = new LatLng(jsonManeuver.get("waypoint").asArray());
		else
			location = null;
		
		bearingBefore = jsonManeuver.getInt("bearing_before", -1);
		bearingAfter = jsonManeuver.getInt("bearing_after", -1);
		type = jsonManeuver.getString("type", "");
		
		modifier = jsonManeuver.getString("modifier", "");
		exit = jsonManeuver.getInt("exit", -1);
		
	}
	
}
