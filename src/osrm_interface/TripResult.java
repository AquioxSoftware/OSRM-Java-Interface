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
	
}
