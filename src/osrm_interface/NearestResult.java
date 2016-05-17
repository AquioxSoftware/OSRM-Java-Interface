package osrm_interface;

public class NearestResult {

	public final String code;
	public final Waypoint[] waypoints;
	
	public NearestResult(String inCode) {
		
		code = inCode;
		waypoints = new Waypoint[0];
		
	}
	
	public NearestResult(String inCode, Waypoint[] inWaypoints) {
		
		code = inCode;
		waypoints = inWaypoints;
		
	}
	
}
