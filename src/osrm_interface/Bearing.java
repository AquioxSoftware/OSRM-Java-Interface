package osrm_interface;

public class Bearing {

	private final double angleToTrueNorth;
	private final double range;
	
	public Bearing(double inAngleToTrueNorth, double inRange) {
			
		angleToTrueNorth = inAngleToTrueNorth;
		range = inRange;
		
	}
	
	public double getAngleToTrueNorth() {
		
		return angleToTrueNorth;
		
	}
	
	public double getRange() {
		
		return range;
		
	}
	
}
