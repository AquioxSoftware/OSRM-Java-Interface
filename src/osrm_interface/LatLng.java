package osrm_interface;

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
