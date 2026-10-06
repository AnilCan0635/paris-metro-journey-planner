import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		 try {
	            JourneyPlanner journeyPlanner = new JourneyPlanner();

	            // Read Metro Data
	            journeyPlanner.readMetroData("Paris_RER_Metro_v2.csv");

	            //  Perform Journey Queries
	            List<List<Stop>> result = journeyPlanner.findBestJourneyMinTime("Bolivar", "Poissonnière");

	            //  Display Result
	            System.out.println("Best Journeys:");
	            for (List<Stop> path : result) {
	                System.out.println(path);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
