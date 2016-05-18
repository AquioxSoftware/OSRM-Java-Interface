package osrm_interface;

public class StepManeuver {
	
	public final LatLng location;
	public final double bearingBefore;
	public final double bearingAfter;
	public final String type;
	
	public final String modifier;
	public final int exit;
	
	public StepManeuver(LatLng inLocation, double inbearingBefore, double inBearingAfter,
			String inType) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = "";
		exit = -1;
		
	}
	
	public StepManeuver(LatLng inLocation, double inbearingBefore, double inBearingAfter,
			String inType, String inModifier) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = inModifier;
		exit = -1;
		
	}
	
	public StepManeuver(LatLng inLocation, double inbearingBefore, double inBearingAfter,
			String inType, int inExit) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = "";
		exit = inExit;
		
	}
	
	public StepManeuver(LatLng inLocation, double inbearingBefore, double inBearingAfter,
			String inType, String inModifier, int inExit) {
		
		location = inLocation;
		bearingBefore = inbearingBefore;
		bearingAfter = inBearingAfter;
		type = inType;
		
		modifier = inModifier;
		exit = inExit;
		
	}
	
}
