package osrm_interface;

public class TripResult {

	public final String code;
	public final Waypoint[] waypoints;
	public final Route[] trips;
	
	public TripResult(String inCode) {
		
		code = inCode;
		waypoints = new Waypoint[0];
		trips = new Route[0];
		
	}
	
	public TripResult(String inCode, Waypoint[] inWaypoints, Route[] inTrips) {
		
		code = inCode;
		waypoints = inWaypoints;
		trips = inTrips;
		
	}
	
	public String toString() {
		
		String result = "Code: " + code + '\n';
		
		result += "Waypoints:\n";
		for(Waypoint current : waypoints)
			result += current.location + "\n";
		
		result += "Trips:\n";
		for(Route current : trips)
			result += current.toString();
		
		return result;
		
	}
	
}
