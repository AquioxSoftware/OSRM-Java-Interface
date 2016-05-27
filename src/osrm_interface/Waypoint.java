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
	
	public Waypoint(JsonObject jsonWaypoint) {
		
		name = jsonWaypoint.get("name").asString();
		location = new LatLng(jsonWaypoint.get("location").asArray());
		hint = jsonWaypoint.get("hint").asString();
		
		distance = jsonWaypoint.getDouble("distance", -1);
		matchingsIndex = jsonWaypoint.getInt("matchings_index", -1);
		waypointIndex = jsonWaypoint.getInt("waypoint_index", -1);
		tripsIndex = jsonWaypoint.getInt("trips_index", -1);
		
	}
	
}
