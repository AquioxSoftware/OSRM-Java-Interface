package osrm_interface;

public class Waypoint {
	
	public final String name;
	public final double latitude;
	public final double longitude;
	public final String hint;
	
	public final double distance;
	public final int matchingsIndex;
	public final int waypointIndex;
	public final int tripsIndex;

	public Waypoint(String inName, double inLatitude, double inLongitude, String inHint) {
		
		name = inName;
		latitude = inLatitude;
		longitude = inLongitude;
		hint = inHint;
		
		distance = -1;
		matchingsIndex = -1;
		waypointIndex = -1;
		tripsIndex = -1;
		
	}
	
	public Waypoint(String inName, double inLatitude, double inLongitude, String inHint, double inDistance) {
		
		name = inName;
		latitude = inLatitude;
		longitude = inLongitude;
		hint = inHint;
		
		distance = inDistance;
		matchingsIndex = -1;
		waypointIndex = -1;
		tripsIndex = -1;
		
	}
	
	public Waypoint(String inName, double inLatitude, double inLongitude, String inHint, int inMatchingsIndex,
			int inWaypointIndex) {
		
		name = inName;
		latitude = inLatitude;
		longitude = inLongitude;
		hint = inHint;
		
		distance = -1;
		matchingsIndex = inMatchingsIndex;
		waypointIndex = inWaypointIndex;
		tripsIndex = -1;
		
	}
	
	public Waypoint(String inName, double inLatitude, double inLongitude, int inTripsIndex, int inWaypointIndex,
			String inHint) {
		
		name = inName;
		latitude = inLatitude;
		longitude = inLongitude;
		hint = inHint;
		
		distance = -1;
		matchingsIndex = -1;
		waypointIndex = inWaypointIndex;
		tripsIndex = inTripsIndex;
		
	}
	
}
