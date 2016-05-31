package osrm_interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import minimal_json.Json;
import minimal_json.JsonArray;
import minimal_json.JsonObject;
import minimal_json.JsonValue;

public class TableRequest {

	private String baseTextURL;
	private final String tableTextURL = "/table/v1/";
	private String profile;
	private ArrayList<LatLng> locations;
	
	private ArrayList<Bearing> bearings;
	private ArrayList<Double> radius;
	private ArrayList<String> hints;
	
	private ArrayList<Integer> sources;
	private ArrayList<Integer> destinations;
	
	public TableRequest() {
		
		baseTextURL = "http://localhost:5000";
		profile = "driving";
		locations = new ArrayList<LatLng>(0);
		
		bearings = new ArrayList<Bearing>(0);
		radius = new ArrayList<Double>(0);
		hints = new ArrayList<String>(0);
		
		sources = new ArrayList<Integer>(0);
		destinations = new ArrayList<Integer>(0);
		
	}
	
	public void setServer(String inBaseTextURL) {
		
		baseTextURL = inBaseTextURL;
		
	}
	
	public void setProfile(String inProfile) {
		
		profile = inProfile;
		
	}
	
	public void addLocation(LatLng inLocation) {
		
		locations.add(inLocation);
		
	}
	
	public void addLocation(double inLatitude, double inLongitude) {
		
		locations.add(new LatLng(inLatitude, inLongitude));
		
	}
	
	public void addBearing(Bearing inBearing) {
		
		bearings.add(inBearing);
		
	}
	
	public void addRadius(double inRadius) {
		
		radius.add(inRadius);
		
	}
	
	public void addHint(String inHint) {
		
		hints.add(inHint);
		
	}
	
	public void addSource(int inSource) {
		
		sources.add(inSource);
		
	}
	
	public void addDestination(int inDestination) {
		
		destinations.add(inDestination);
		
	}
	
	public TableResult makeRequest() {
		
		String requestTextURL = baseTextURL;
		requestTextURL += tableTextURL;
		requestTextURL += profile + "/";
		requestTextURL += addLocations();
		requestTextURL += addOptions();
		
		System.out.println("INFO: Request: " + requestTextURL);
		String jsonText = getJsonFromURL(requestTextURL);
		
		JsonObject mainJsonObject = Json.parse(jsonText).asObject();
		JsonValue statusCode = mainJsonObject.get("code");
		
		if(!statusCode.asString().equals("Ok"))
			return new TableResult(statusCode.asString());
		
		JsonArray jsonDurations = mainJsonObject.get("durations").asArray();
		JsonArray jsonSources = mainJsonObject.get("sources").asArray();
		JsonArray jsonDestinations = mainJsonObject.get("destinations").asArray();
		
		Waypoint[] sources = new Waypoint[jsonSources.size()];
		Waypoint[] destinations = new Waypoint[jsonDestinations.size()];
		
		double[][] durations = new double[jsonDurations.size()][jsonDurations.get(0).asArray().size()];
		
		for(int i = 0; i < durations.length; i++)
			for(int ii = 0; ii < durations[0].length; ii++)
				durations[i][ii] = jsonDurations.get(i).asArray().get(ii).asDouble();
		
		for(int i = 0; i < sources.length; i++)
			sources[i] = new Waypoint(jsonSources.get(i).asObject());
		
		for(int i = 0; i < destinations.length; i++)		
			destinations[i] = new Waypoint(jsonDestinations.get(i).asObject());
		
		return new TableResult(statusCode.asString(), durations, sources, destinations);
		
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
		
		if(sources.size() > 0) {
			
			if(result.length() == 0) {
				result = "?sources=";
			} else {
				result += "&sources=";
			}
			
			result += sources.get(0);
			
			for(int i = 1; i < sources.size(); i++)
				result += "," + sources.get(i);
			
			result += ";";
			
		}
		
		if(destinations.size() > 0) {
			
			if(result.length() == 0) {
				result = "?destinations=";
			} else {
				result += "&destinations=";
			}
			
			result += destinations.get(0);
			
			for(int i = 1; i < destinations.size(); i++)
				result += "," + destinations.get(i);
			
			result += ";";
			
		}
		
		if(bearings.size() > 0) {
			
			if(result.length() == 0) {
				result = "?bearings=";
			} else {
				result += "&bearings=";
			}
			
			result += bearings.get(0).getAngleToTrueNorth() + "," + bearings.get(0).getRange();
			
			for(int i = 1; i < bearings.size(); i++)
				result += ";" + bearings.get(i).getAngleToTrueNorth() + "," + bearings.get(i).getRange();
			
		}
		
		if(radius.size() > 0) {
			
			if(result.length() == 0) {
				result = "?radiuses=";
			} else {
				result += "&radiuses=";
			}
			
			result += radius.get(0);
			
			for(int i = 1; i < radius.size(); i++)
				result += ";" + radius.size();
			
		}
		
		if(hints.size() > 0) {
			
			if(result.length() == 0) {
				result = "?hints=";
			} else {
				result += "&hints=";
			}
			
			result += hints.get(0);
			
			for(int i = 1; i < hints.size(); i++)
				result += ";" + hints.get(i);
			
		}
		
		return result;
		
	}
	
	private String getJsonFromURL(String url) {
		
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
