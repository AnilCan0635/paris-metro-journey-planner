import java.util.*;

public class Graph {
	List<Stop> stops;
    List<Edge> edges;

    Graph() {
        stops = new ArrayList<>();
        edges = new ArrayList<>();
    }

    void addStop(Stop stop) {
        stops.add(stop);
    }

    void addEdge(Stop source, Stop destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }
}
