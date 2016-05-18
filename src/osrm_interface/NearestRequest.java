package osrm_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import minimal_json.Json;
import minimal_json.JsonArray;
import minimal_json.JsonObject;
import minimal_json.JsonValue;

public class NearestRequest {

	private String baseTextURL;
	private final String nearestTextURL = "/nearest/v1/";
	
	private LatLng location;
	private String profile;
	private int numberOfLocations;
	
	public NearestRequest() {
		
		baseTextURL = "http://localhost:5000";
		location = new LatLng();
		profile = "driving";
		numberOfLocations = 1;
		
	}
	
	public void setServer(String inBaseTextURL) {
		
		baseTextURL = inBaseTextURL;
		
	}
	
	public void setLocation(LatLng inLocation) {
		
		location = inLocation;
		
	}
	
	public void setLocation(double inLatitude, double inLongitude) {
		
		location = new LatLng(inLatitude, inLongitude);
		
	}
	
	public void setProfile(String inProfile) {
		
		profile = inProfile;
		
	}
	
	public boolean setNumberOfLocations(int number) {
		
		if(number > 0)
			numberOfLocations = number;
		return number > 0;
		
	}
	
	public NearestResult makeRequest() {
		
		String requestTextURL = baseTextURL;
		requestTextURL += nearestTextURL;
		requestTextURL += profile + "/";
		requestTextURL += location.getLng() + "," + location.getLat();
		requestTextURL += "?number=" + numberOfLocations;
		
		String jsonText = getJsonFromURL(requestTextURL);
		
		JsonObject mainJsonObject = Json.parse(jsonText).asObject();
		JsonValue statusCode = mainJsonObject.get("code");
		
		if(!statusCode.asString().equals("Ok"))
			return new NearestResult(statusCode.asString());
		
		JsonArray jsonWaypoints = mainJsonObject.get("waypoints").asArray();
		
		Waypoint[] waypoints = new Waypoint[numberOfLocations];
		
		for(int i = 0; i < numberOfLocations; i++) {
			
			JsonArray temp = jsonWaypoints.get(i).asObject().get("location").asArray();
			
			waypoints[i] = new Waypoint(jsonWaypoints.get(i).asObject().get("name").asString(),
					new LatLng(temp.get(1).asDouble(), temp.get(0).asDouble()),
					jsonWaypoints.get(i).asObject().get("hint").asString(),
					jsonWaypoints.get(i).asObject().get("distance").asDouble());
			
		}
		
		return new NearestResult(statusCode.asString(), waypoints);
		
	}
	
	public String getJsonFromURL(String url) {
		
		String jsonText = "";
		
		try {
			
			URL request = new URL(url);
        	BufferedReader in = new BufferedReader(new InputStreamReader(request.openStream()));
			
			String inputLine;
			
	        while ((inputLine = in.readLine()) != null)
	        	jsonText += inputLine;
	        
	        in.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonText;
		
	}
	
}
