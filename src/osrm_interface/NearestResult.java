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
	
	public String toString() {
		
		String result = "Code: " + code + "\n";
		
		for(Waypoint current : waypoints)
			result += current.location + " at a distance of " + current.distance + "\n";
		
		return result;
		
	}
	
}
