# 🚇 Paris Metro & RER Journey Planner

A high-performance graph-based route optimization engine and transit network simulator implemented in **Java**. 

The system models the Paris Metropolitan transit network (RER and Metro) as a weighted, directed multigraph to compute optimal travel trajectories, minimizing both transit duration and transfer penalties.

---

## 📌 Features

- **Graph-Based Transit Modeling:** Custom adjacency list representations supporting transit vertices (`Stop`) and weighted directed connections (`Edge`).
- **Shortest Path Optimization:** Employs priority-queue-based graph traversal algorithms (Dijkstra) to determine optimal paths between stations.
- **Real-World Network Data:** Parses and processes comprehensive transit timetable and station coordinates from CSV datasets.
- **Transfer Penalty Logic:** Accounts for station transfer times and line switching overheads during path evaluation.

---

## 🏛️ Project Structure

```text
paris-metro-journey-planner/
├── src/
│   ├── Edge.java             # Weighted directed edge representation
│   ├── Graph.java            # Adjacency list and graph traversal routines
│   ├── Stop.java             # Transit station node with spatial metadata
│   ├── JourneyPlanner.java   # Core pathfinding and routing logic
│   └── Main.java             # Entry point and benchmarking suite
├── Paris_RER_Metro_v2.csv    # Transit network adjacency dataset
├── Test100.csv               # Automated query benchmark suite
├── Report.pdf                # Algorithmic analysis and complexity benchmark
├── .gitignore
└── README.md
```

---

## 🚀 Getting Started

Compile and run via command line:

```bash
javac -d bin src/*.java
java -cp bin Main
```