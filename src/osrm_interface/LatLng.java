package osrm_interface;

import minimal_json.JsonObject;

public class LatLng {

	private double latitude;
	private double longitude;
	
	public LatLng() {
		
		latitude = 0;
		longitude = 0;
		
	}
	
	public LatLng(LatLng other) {
		
		latitude = other.getLat();
		longitude = other.getLng();
		
	}
	
	public LatLng(double inLatitude, double inLongitude) {
		
		latitude = inLatitude;
		longitude = inLongitude;
		
	}
	
	public LatLng(JsonObject inLatLng) {
		
		latitude = inLatLng.asArray().get(1).asDouble();
		longitude = inLatLng.asArray().get(0).asDouble();
		
	}
	
	public void setLat(double inLatitude) {
		
		latitude = inLatitude;
		
	}
	
	public void setLng(double inLongitude) {
		
		longitude = inLongitude;
		
	}
	
	public double getLat() {
		
		return latitude;
		
	}
	
	public double getLng() {
		
		return longitude;
		
	}
	
}
