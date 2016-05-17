package osrm_interface;

public class Annotation {

	public final double[] distances;
	public final double[] durations;
	
	public Annotation(double[] inDistances, double[] inDurations) {
		
		distances = inDistances;
		durations = inDurations;
		
	}
	
}
