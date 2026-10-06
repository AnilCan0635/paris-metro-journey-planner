import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JourneyPlanner {
	Graph graph;

    JourneyPlanner() {
        graph = new Graph();
    }

    //  Read Metro Data
    void readMetroData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String stopId = parts[0].trim();
            String stopName = parts[1].trim();
            String arrivalTime = parts[2].trim();
            String stopSequence = parts[3].trim();
            String directionId = parts[4].trim();
            String routeShortName = parts[5].trim();
            String routeLongName = parts[6].trim();
            String routeType = parts[7].trim();

            Stop stop = new Stop(stopId, stopName, arrivalTime, stopSequence, directionId, routeShortName, routeLongName, routeType);

            graph.addStop(stop);
        }

        reader.close();
    }

        // Helper method to retrieve a stop by name
        private Stop getStop(String stopName) {
            for (Stop stop : graph.stops) {
                 if (stop.stopName.equals(stopName)) {
                     return stop;
                }
            }
            return null;
        }

        //  Find Best Journey - Minimum Time
        List<List<Stop>> findBestJourneyMinTime(String originName, String destinationName) {
        Stop origin = getStop(originName);
        Stop destination = getStop(destinationName);

        if (origin == null || destination == null) {
            throw new IllegalArgumentException("Invalid origin or destination");
        }

        //  Dijkstra's Algorithm
        Map<Stop, Integer> time = new HashMap<>();
        Map<Stop, List<Stop>> paths = new HashMap<>();

        for (Stop stop : graph.stops) {
            time.put(stop, Integer.MAX_VALUE);
            paths.put(stop, new ArrayList<>());
        }

        time.put(origin, 0);

        PriorityQueue<Stop> queue = new PriorityQueue<>(Comparator.comparingInt(time::get));
        queue.add(origin);

        while (!queue.isEmpty()) {
            Stop current = queue.poll();

            for (Edge edge : getEdgesFromStop(current)) {
                int newTime = time.get(current) + edge.weight;

                if (newTime < time.get(edge.destination)) {
                    time.put(edge.destination, newTime);

                    List<Stop> newPath = new ArrayList<>(paths.get(current));
                    newPath.add(current);
                    paths.put(edge.destination, newPath);

                    queue.add(edge.destination);
                }
            }
        }

        //  Extract Paths
        List<List<Stop>> resultPaths = new ArrayList<>();
        List<Stop> path = new ArrayList<>();
        Stop current = destination;

        while (current != origin) {
            path.add(current);
            current = paths.get(current).isEmpty() ? null : paths.get(current).get(0);
        }
        path.add(origin);

        Collections.reverse(path);
        resultPaths.add(path);

        return resultPaths;
    }

    // Helper method to get edges from a stop
    private List<Edge> getEdgesFromStop(Stop stop) {
        List<Edge> edgesFromStop = new ArrayList<>();
        for (Edge edge : graph.edges) {
            if (edge.source.equals(stop)) {
                edgesFromStop.add(edge);
            }
        }
        return edgesFromStop;
    }
}
