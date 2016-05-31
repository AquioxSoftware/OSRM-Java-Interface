package osrm_interface;

public class TableResult {

	public final String code;
	public final double[][] durations;
	public final Waypoint[] sources;
	public final Waypoint[] destinations;
	
	public TableResult(String inCode) {
		
		code = inCode;
		durations = new double[0][0];
		sources = new Waypoint[0];
		destinations = new Waypoint[0];
		
	}
	
	public TableResult(String inCode, double[][] inDurations, Waypoint[] inSources, Waypoint[] inDestinations) {
		
		code = inCode;
		durations = inDurations;
		sources = inSources;
		destinations = inDestinations;
		
	}
	
	public String toString() {
		
		String result = "Code: " + code + '\n';
		
		result += "Durations:\n";
		
		for(int i = 0; i < durations.length; i++) {
			
			for(int ii = 0; ii < durations[0].length; ii++) {
				
				result += durations[i][ii] + "  ";
						
			}
			
			result += '\n';
			
		}
		
		result += "Sources:\n";
		for(Waypoint current : sources)
			result += current.location + "\n";
		
		result += "Destinations:\n";
		for(Waypoint current : destinations)
			result += current.location + "\n";
		
		return result;
		
	}
	
}
