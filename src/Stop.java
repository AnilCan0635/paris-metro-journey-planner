
public class Stop {
	
	String stopId;
    String stopName;
    String arrivalTime;
    String stopSequence;
    String directionId;
    String routeShortName;
    String routeLongName;
    String routeType;

    Stop(String stopId, String stopName, String arrivalTime, String stopSequence2, String directionId2, String routeShortName, String routeLongName, String routeType2) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.arrivalTime = arrivalTime;
        this.stopSequence = stopSequence2;
        this.directionId = directionId2;
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeType = routeType2;
    }
}
