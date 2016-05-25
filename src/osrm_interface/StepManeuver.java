package osrm_interface;

import minimal_json.JsonObject;

public class StepManeuver {
	
	public final LatLng location;
	public final int bearingBefore;
	public final int bearingAfter;
	public final String type;
	
	public final String modifier;
	public final int exit;
	
	public StepManeuver(LatLng inLocation, int inbearingBefore, int inBearingAfter,
			String inType) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = "";
		exit = -1;
		
	}
	
	public StepManeuver(LatLng inLocation, int inbearingBefore, int inBearingAfter,
			String inType, String inModifier) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = inModifier;
		exit = -1;
		
	}
	
	public StepManeuver(LatLng inLocation, int inbearingBefore, int inBearingAfter,
			String inType, int inExit) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = "";
		exit = inExit;
		
	}
	
	public StepManeuver(LatLng inLocation, int inbearingBefore, int inBearingAfter,
			String inType, String inModifier, int inExit) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = inModifier;
		exit = inExit;
		
	}

	public StepManeuver(JsonObject jsonManeuver) {
		
		location = new LatLng(jsonManeuver.get("waypoint").asArray());
		bearingBefore = jsonManeuver.getInt("bearing_before", -1);
		bearingAfter = jsonManeuver.getInt("bearing_after", -1);
		type = jsonManeuver.getString("type", "");
		
		modifier = jsonManeuver.getString("modifier", "");
		exit = jsonManeuver.getInt("exit", -1);
		
	}
	
}
