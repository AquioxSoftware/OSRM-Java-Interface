package osrm_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import minimal_json.Json;
import minimal_json.JsonArray;
import minimal_json.JsonObject;
import minimal_json.JsonValue;

public class NearestRequest {

	private String baseTextURL;
	private final String nearestTextURL = "/nearest/v1/";
	private String profile;
	private ArrayList<LatLng> locations;
	
	private ArrayList<Bearing> bearings;
	private ArrayList<Double> radius;
	private ArrayList<String> hints;
	
	private int numberOfLocations;
	
	public NearestRequest() {
		
		baseTextURL = "http://localhost:5000";
		profile = "driving";
		locations = new ArrayList<LatLng>(0);
		locations.add(new LatLng());
		
		bearings = new ArrayList<Bearing>(0);
		radius = new ArrayList<Double>(0);
		hints = new ArrayList<String>(0);
		
		numberOfLocations = 1;
		
	}
	
	public void setServer(String inBaseTextURL) {
		
		baseTextURL = inBaseTextURL;
		
	}
	
	public void setProfile(String inProfile) {
		
		profile = inProfile;
		
	}
	
	public void setLocation(LatLng inLocation) {
		
		locations.set(0, inLocation);
		
	}
	
	public void setLocation(double inLatitude, double inLongitude) {
		
		locations.set(0, new LatLng(inLatitude, inLongitude));
		
	}
	
	public void addBearing(int inAngleWithTrueNorth, int inRange) {
		
		bearings.add(new Bearing(inAngleWithTrueNorth, inRange));
		
	}
	
	public void addRadius(double inRadius) {
		
		radius.add(inRadius);
		
	}
	
	public void addHint(String inHint) {
		
		hints.add(inHint);
		
	}
	
	public void setNumberOfLocations(int number) {
		
		numberOfLocations = number;
		
	}
	
	public NearestResult makeRequest() {
		
		String requestTextURL = baseTextURL;
		requestTextURL += nearestTextURL;
		requestTextURL += profile + "/";
		requestTextURL += addLocations();
		requestTextURL += addOptions();
		
		System.out.println("INFO: Request: " + requestTextURL);
		String jsonText = getJsonFromURL(requestTextURL);
		
		JsonObject mainJsonObject = Json.parse(jsonText).asObject();
		JsonValue statusCode = mainJsonObject.get("code");
		
		if(!statusCode.asString().equals("Ok")) {
			
			System.err.println("INFO: Request Error: Code: \"" + statusCode.asString() + "\" Message: \"" + mainJsonObject.getString("message", "No Message") + "\"");
			return new NearestResult(statusCode.asString());
			
		}
		
		JsonArray jsonWaypoints = mainJsonObject.get("waypoints").asArray();
		Waypoint[] waypoints = new Waypoint[numberOfLocations];
		
		for(int i = 0; i < numberOfLocations; i++)
			waypoints[i] = new Waypoint(jsonWaypoints.get(i).asObject());
		
		return new NearestResult(statusCode.asString(), waypoints);
		
	}
	
	private String addLocations() {
		
		String result = "";
		
		if(locations.size() == 0)
			return result + "?";
		
		result += locations.get(0).getLng() + "," + locations.get(0).getLat();
		
		for(int i = 1; i < locations.size(); i++)
			result += ";" + locations.get(i).getLng() + "," + locations.get(i).getLat();
		
		return result;
		
	}
	
	private String addOptions() {
		
		String result = "";
		
		result += "?number=" + numberOfLocations;
		
		if(bearings.size() > 0) {
			
			result += "&bearings=" + bearings.get(0).getAngleToTrueNorth() + "," + bearings.get(0).getRange();
			
			for(int i = 1; i < bearings.size(); i++)
				result += ";" + bearings.get(i).getAngleToTrueNorth() + "," + bearings.get(i).getRange();
			
		}
		
		if(radius.size() > 0) {
			
			result += "&radiuses=" + radius.get(0);
			
			for(int i = 1; i < radius.size(); i++)
				result += ";" + radius.get(i);
			
		}
		
		if(hints.size() > 0) {
			
			result += "&hints=" + hints.get(0);
			
			for(int i = 1; i < hints.size(); i++)
				result += ";" + hints.get(i);
			
		}
		
		return result;
		
	}
	
	private String getJsonFromURL(String url) {
		
		String jsonText = "";
		
		try {
			
			URL request = new URL(url);
			
			HttpURLConnection httpConnection = (HttpURLConnection)request.openConnection();
			InputStream requestStream;
			
			if (httpConnection.getResponseCode() == 200)
				requestStream = httpConnection.getInputStream();
			else
				requestStream = httpConnection.getErrorStream();
			
        	BufferedReader in = new BufferedReader(new InputStreamReader(requestStream));
			
			String inputLine;
			
	        while ((inputLine = in.readLine()) != null)
	        	jsonText += inputLine;
	        
	        in.close();
	        
		} catch (IOException e) {
			
			System.err.println("INFO: Connection Error");
			
		}
		
		return jsonText;
		
	}
	
}
