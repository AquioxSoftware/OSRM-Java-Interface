package osrm_interface;

import minimal_json.JsonArray;
import minimal_json.JsonObject;

public class Annotation {

	public final double[] distances;
	public final double[] durations;
	
	public Annotation(JsonObject jsonAnnotation) {
		
		if(jsonAnnotation.get("distance") != null) {
			
			JsonArray jsonDistances = jsonAnnotation.get("distance").asArray();
			JsonArray jsonDurations = jsonAnnotation.get("duration").asArray();
			
			double[] inDistances = new double[jsonDistances.size()];
			double[] inDurations = new double[jsonDurations.size()];
			
			for(int i = 0; i < inDistances.length; i++)
				inDistances[i] = jsonDistances.get(i).asDouble();
			
			for(int i = 0; i < inDurations.length; i++)
				inDurations[i] = jsonDurations.get(i).asDouble();
			
			distances = inDistances;
			durations = inDurations;
			
		} else {
			
			distances = null;
			durations = null;
			
		}
		
	}
	
}
