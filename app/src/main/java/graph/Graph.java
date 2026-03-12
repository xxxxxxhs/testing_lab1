package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Integer, List<Integer>> adjacency;

    public Graph() {
        this.adjacency = new HashMap<>();
    }

    public void addVertex(int v) {
        adjacency.computeIfAbsent(v, key -> new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        addVertex(u);
        addVertex(v);

        if (!adjacency.get(u).contains(v)) {
            adjacency.get(u).add(v);
        }

        if (!adjacency.get(v).contains(u)) {
            adjacency.get(v).add(u);
        }
    }

    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = adjacency.get(v);
        if (neighbors == null) {
            return Collections.emptyList();
        }
        return neighbors;
    }

    public List<Integer> getVertices() {
        return new ArrayList<>(adjacency.keySet());
    }
}

