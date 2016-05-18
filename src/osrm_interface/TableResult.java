package osrm_interface;

public class TableResult {

	public final String code;
	public final double[] durations;
	public final Waypoint[] sources;
	public final Waypoint[] destinations;
	
	public TableResult(String inCode) {
		
		code = inCode;
		durations = new double[0];
		sources = new Waypoint[0];
		destinations = new Waypoint[0];
		
	}
	
	public TableResult(String inCode, double[] inDurations, Waypoint[] inSources, Waypoint[] inDestinations) {
		
		code = inCode;
		durations = inDurations;
		sources = inSources;
		destinations = inDestinations;
		
	}
	
}
