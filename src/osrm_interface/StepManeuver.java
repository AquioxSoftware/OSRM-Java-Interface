package osrm_interface;

public class StepManeuver {
	
	public final double latitude;
	public final double longitude;
	public final double bearingBefore;
	public final double bearingAfter;
	public final String type;
	
	public final String modifier;
	public final int exit;
	
	public StepManeuver(double inLatitude, double inLongitude, double inbearingBefore, double inBearingAfter,
			String inType) {
		
		latitude = inLatitude;
		longitude = inLongitude;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = "";
		exit = -1;
		
	}
	
	public StepManeuver(double inLatitude, double inLongitude, double inbearingBefore, double inBearingAfter,
			String inType, String inModifier) {
		
		latitude = inLatitude;
		longitude = inLongitude;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = inModifier;
		exit = -1;
		
	}
	
	public StepManeuver(double inLatitude, double inLongitude, double inbearingBefore, double inBearingAfter,
			String inType, int inExit) {
		
		latitude = inLatitude;
		longitude = inLongitude;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = "";
		exit = inExit;
		
	}
	
	public StepManeuver(double inLatitude, double inLongitude, double inbearingBefore, double inBearingAfter,
			String inType, String inModifier, int inExit) {
		
		latitude = inLatitude;
		longitude = inLongitude;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = inModifier;
		exit = inExit;
		
	}
	
}
