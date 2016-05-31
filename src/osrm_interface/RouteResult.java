package osrm_interface;

public class RouteResult {

	public final String code;
	public final Waypoint[] waypoints;
	public final Route[] routes;
	
	public RouteResult(String inCode) {
		
		code = inCode;
		waypoints = new Waypoint[0];
		routes = new Route[0];
		
	}
	
	public RouteResult(String inCode, Waypoint[] inWaypoints, Route[] inRoutes) {
		
		code = inCode;
		waypoints = inWaypoints;
		routes = inRoutes;
		
	}
	
	public String toString() {
		
		String result = "Code: " + code + "\n";
		
		result += "Waypoints:\n";
		
		for(Waypoint current : waypoints)
			result += current.location + "\n";
		
		result += "Routes:\n";
		
		for(Route current : routes)
			result += current.toString();
		
		return result;
		
	}
	
}
