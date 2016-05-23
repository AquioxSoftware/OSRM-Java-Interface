package osrm_interface;

import minimal_json.JsonObject;

public class Waypoint {
	
	public final String name;
	public final LatLng location;
	public final String hint;
	
	public final double distance;
	public final int matchingsIndex;
	public final int waypointIndex;
	public final int tripsIndex;

	public Waypoint(String inName, LatLng inLocation, String inHint) {
		
		name = inName;
		location = inLocation;
		hint = inHint;
		
		distance = -1;
		matchingsIndex = -1;
		waypointIndex = -1;
		tripsIndex = -1;
		
	}
	
	public Waypoint(String inName, LatLng inLocation, String inHint, double inDistance) {
		
		name = inName;
		location = inLocation;
		hint = inHint;
		
		distance = inDistance;
		matchingsIndex = -1;
		waypointIndex = -1;
		tripsIndex = -1;
		
	}
	
	public Waypoint(String inName, LatLng inLocation, String inHint, int inMatchingsIndex,
			int inWaypointIndex) {
		
		name = inName;
		location = inLocation;
		hint = inHint;
		
		distance = -1;
		matchingsIndex = inMatchingsIndex;
		waypointIndex = inWaypointIndex;
		tripsIndex = -1;
		
	}
	
	public Waypoint(String inName, LatLng inLocation, int inTripsIndex, int inWaypointIndex,
			String inHint) {
		
		name = inName;
		location = inLocation;
		hint = inHint;
		
		distance = -1;
		matchingsIndex = -1;
		waypointIndex = inWaypointIndex;
		tripsIndex = inTripsIndex;
		
	}
	
	public Waypoint(JsonObject jsonWaypoint) {
		
		name = jsonWaypoint.get("name").asString();
		location = new LatLng(jsonWaypoint.get("location").asObject());
		hint = jsonWaypoint.get("hint").asString();
		
		distance = jsonWaypoint.getDouble("distance", -1);
		matchingsIndex = jsonWaypoint.getInt("matchings_index", -1);
		waypointIndex = jsonWaypoint.getInt("waypoint_index", -1);
		tripsIndex = jsonWaypoint.getInt("trips_index", -1);
		
	}
	
}
