package osrm_interface;

import minimal_json.JsonArray;
import minimal_json.JsonObject;

public class Intersection {

	public final LatLng location;
	public final int[] bearings;
	public final boolean[] entry;
	public final int in, out;
	
	public Intersection(JsonObject jsonIntersection) {
		
		location = new LatLng(jsonIntersection.get("location").asArray());
		in = jsonIntersection.getInt("in", -1);
		out = jsonIntersection.getInt("out", -1);
		
		JsonArray jsonBearings = jsonIntersection.get("bearings").asArray();
		JsonArray jsonEntry = jsonIntersection.get("entry").asArray();
		
		int[] inBearings = new int[jsonBearings.size()];
		boolean[] inEntry = new boolean[jsonEntry.size()];
		
		for(int i = 0; i < inBearings.length; i++) {
			
			inBearings[i] = jsonBearings.get(i).asInt();
			inEntry[i] = jsonEntry.get(i).asBoolean();
			
		}
		
		bearings = inBearings;
		entry = inEntry;
		
	}
	
}
