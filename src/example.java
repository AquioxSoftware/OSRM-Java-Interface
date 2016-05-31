import osrm_interface.MatchRequest;
import osrm_interface.MatchResult;
import osrm_interface.NearestRequest;
import osrm_interface.NearestResult;
import osrm_interface.RouteRequest;
import osrm_interface.RouteResult;
import osrm_interface.TableRequest;
import osrm_interface.TableResult;
import osrm_interface.TripRequest;
import osrm_interface.TripResult;

public class example {

	public static void main(String[] args) {
		
		testNearest();
		testRoute();
		testTable();
		testMatch();
		testTrip();

	}
	
	public static void testNearest() {
		
		NearestRequest sampleRequest = new NearestRequest();
		
		sampleRequest.setServer("http://router.project-osrm.org");
		sampleRequest.setLocation(52.517037, 13.388860);
		sampleRequest.setNumberOfLocations(3);
		
		NearestResult sampleResult = sampleRequest.makeRequest();
		
		System.out.println(sampleResult);
		
	}
	
	public static void testRoute() {
		
		RouteRequest sampleRequest = new RouteRequest();
		
		sampleRequest.setServer("http://router.project-osrm.org");
		sampleRequest.addLocation(40.235551, -83.044735);
		sampleRequest.addLocation(40.267846, -83.070398);
		sampleRequest.addLocation(40.268133, -83.112423);
		sampleRequest.setAnnotate(true);
		sampleRequest.setAlternatives(true);
		sampleRequest.setContinueStraight(true);
		sampleRequest.setGeometries(sampleRequest.POLYLINE);
		sampleRequest.setOverview(sampleRequest.FULL);
		sampleRequest.setProfile("driving");
		sampleRequest.setSteps(true);
		
		RouteResult sampleResult = sampleRequest.makeRequest();
		
		System.out.println(sampleResult);
		
	}
	
	public static void testTable() {
		
		TableRequest sampleRequest = new TableRequest();
		
		sampleRequest.setServer("http://router.project-osrm.org");
		sampleRequest.addLocation(40.235551, -83.044735);
		sampleRequest.addLocation(40.267846, -83.070398);
		sampleRequest.addLocation(40.268133, -83.112423);
		
		TableResult sampleResult = sampleRequest.makeRequest();
		
		System.out.println(sampleResult);
		
		
	}
	
	public static void testMatch() {
		
		MatchRequest sampleRequest = new MatchRequest();
		
		sampleRequest.setServer("http://router.project-osrm.org");
		sampleRequest.addLocation(40.284230, -83.198458);
		sampleRequest.addLocation(40.284115, -83.199574);
		sampleRequest.addLocation(40.283992, -83.201108);
		sampleRequest.addRadius(5);
		sampleRequest.addRadius(5);
		sampleRequest.addRadius(5);
		sampleRequest.setAnnotate(true);
		sampleRequest.setOverview(sampleRequest.FULL);
		sampleRequest.setSteps(true);
		
		MatchResult sampleResult = sampleRequest.makeRequest();
		
		System.out.println(sampleResult);
		
	}
	
	public static void testTrip() {
		
		TripRequest sampleRequest = new TripRequest();
		
		sampleRequest.setServer("http://router.project-osrm.org");
		sampleRequest.addLocation(40.307314, -83.304491);
		sampleRequest.addLocation(40.365608, -83.291520);
		sampleRequest.addLocation(40.208399, -83.060668);
		sampleRequest.addLocation(40.234900, -83.262756);
		sampleRequest.setAnnotate(true);
		sampleRequest.setOverview(sampleRequest.FULL);
		sampleRequest.setSteps(true);
		
		TripResult sampleResult = sampleRequest.makeRequest();
		
		System.out.println(sampleResult);
		
	}

}
