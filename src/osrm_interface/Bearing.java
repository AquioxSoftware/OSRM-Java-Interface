package osrm_interface;

public class Bearing {

	private final int angleToTrueNorth;
	private final int range;
	
	public Bearing(int inAngleToTrueNorth, int inRange) {
			
		angleToTrueNorth = inAngleToTrueNorth;
		range = inRange;
		
	}
	
	public int getAngleToTrueNorth() {
		
		return angleToTrueNorth;
		
	}
	
	public int getRange() {
		
		return range;
		
	}
	
}
