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

public class RouteRequest {

	private String baseTextURL;
	private final String routeTextURL = "/route/v1/";
	private String profile;
	private ArrayList<LatLng> locations;
	
	private ArrayList<Bearing> bearings;
	private ArrayList<Double> radius;
	private ArrayList<String> hints;
	
	private boolean alternatives, steps, annotate, geometries, continueStraight;
	private int overview;
	
	public final boolean POLYLINE = true;
	public final boolean GEOJSON = false;
	public final int SIMPLIFIED = 0;
	public final int FULL = 1;
	public final int FALSE = 2;
	
	public RouteRequest() {
		
		baseTextURL = "http://localhost:5000";
		profile = "driving";
		locations = new ArrayList<LatLng>(0);
		
		bearings = new ArrayList<Bearing>(0);
		radius = new ArrayList<Double>(0);
		hints = new ArrayList<String>(0);
		
		alternatives = false;
		steps = false;
		annotate = false;
		geometries = POLYLINE;
		continueStraight = false;
		overview = SIMPLIFIED;
		
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
	
	public void setAlternatives(boolean inAlternatives) {
		
		alternatives = inAlternatives;
		
	}
	
	public void setSteps(boolean inSteps) {
		
		steps = inSteps;
		
	}
	
	public void setAnnotate(boolean inAnnotate) {
		
		annotate = inAnnotate;
		
	}
	
	public void setGeometries(boolean inGeometries) {
		
		geometries = inGeometries;
		
	}
	
	public void setContinueStraight(boolean inContinueStraight) {
		
		continueStraight = inContinueStraight;
		
	}
	
	public void setOverview(int inOverview) {
		
		overview = inOverview;
		
	}
	
	public RouteResult makeRequest() {
		
		String requestTextURL = baseTextURL;
		requestTextURL += routeTextURL;
		requestTextURL += profile + "/";
		requestTextURL += addLocations();
		requestTextURL += addOptions();
		
		System.out.println("INFO: Request: " + requestTextURL);
		String jsonText = getJsonFromURL(requestTextURL);
		
		JsonObject mainJsonObject = Json.parse(jsonText).asObject();
		JsonValue statusCode = mainJsonObject.get("code");
		
		if(!statusCode.asString().equals("Ok"))
			return new RouteResult(statusCode.asString());
		
		JsonArray jsonRoutes = mainJsonObject.get("routes").asArray();
		JsonArray jsonWaypoints = mainJsonObject.get("waypoints").asArray();
		
		Route[] routes = new Route[jsonRoutes.size()];
		Waypoint[] waypoints = new Waypoint[jsonWaypoints.size()];
		
		for(int i = 0; i < routes.length; i++)
			routes[i] = new Route(jsonRoutes.get(i).asObject());
		
		for(int i = 0; i < waypoints.length; i++)		
			waypoints[i] = new Waypoint(jsonWaypoints.get(i).asObject());
		
		return new RouteResult(statusCode.asString(), waypoints, routes);
		
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
		
		result += "?alternatives=" + alternatives;
		result += "&steps=" + steps;
		result += "&annotations=" + annotate;
		result += "&continue_straight=" + continueStraight;
		
		if(geometries) {
			
			result += "&geometries=polyline";
			
		} else {
			
			result += "&geometries=geojson";
			
		}
		
		switch(overview) {
		
			case 0:
				result += "&overview=simplified";
				break;
				
			case 1:
				result += "&overview=full";
				break;
				
			case 2:
				result += "&overview=false";
				break;
				
		}
		
		if(bearings.size() > 0) {
			
			result += "&bearings=" + bearings.get(0).getAngleToTrueNorth() + "," + bearings.get(0).getRange();
			
			for(int i = 1; i < bearings.size(); i++)
				result += ";" + bearings.get(i).getAngleToTrueNorth() + "," + bearings.get(i).getRange();
			
		}
		
		if(radius.size() > 0) {
			
			result += "&radiuses=" + radius.get(0);
			
			for(int i = 1; i < radius.size(); i++)
				result += ";" + radius.size();
			
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
