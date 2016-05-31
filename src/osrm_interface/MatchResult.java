package osrm_interface;

public class MatchResult {

	public final String code;
	public final Waypoint[] tracepoints;
	public final Route[] matchings;
	
	public MatchResult(String inCode) {
		
		code = inCode;
		tracepoints = new Waypoint[0];
		matchings = new Route[0];
		
	}
	
	public MatchResult(String inCode, Waypoint[] inWaypoints, Route[] inMatchings) {
		
		code = inCode;
		tracepoints = inWaypoints;
		matchings = inMatchings;
		
	}
	
	public String toString() {
		
		String result = "Code: " + code + '\n';
		
		result += "Tracepoints:\n";
		for(Waypoint current : tracepoints)
			result += current.location + "\n";
		
		result += "Matchings:\n";
		for(Route current : matchings)
			result += current.toString();
		
		return result;
		
	}
	
}
