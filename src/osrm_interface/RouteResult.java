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
	
}
