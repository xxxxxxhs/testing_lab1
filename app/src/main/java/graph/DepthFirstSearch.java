package graph;

import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {
    private final Graph graph;

    public DepthFirstSearch(Graph graph) {
        if (graph == null) {
            throw new IllegalArgumentException("graph must not be null");
        }
        this.graph = graph;
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        graph.onDfsStart(start);
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(int vertex, Set<Integer> visited) {
        visitVertex(vertex, visited);
        for (int neighbor : graph.getNeighbors(vertex)) {
            processNeighbor(vertex, neighbor, visited);
        }
        finishVertex(vertex);
    }

    private void visitVertex(int vertex, Set<Integer> visited) {
        graph.onDfsVisit(vertex);
        visited.add(vertex);
    }

    private void processNeighbor(int vertex, int neighbor, Set<Integer> visited) {
        graph.onDfsEdge(vertex, neighbor);
        if (!visited.contains(neighbor)) {
            dfsRecursive(neighbor, visited);
        } else {
            handleAlreadyVisitedNeighbor(neighbor);
        }
    }

    private void handleAlreadyVisitedNeighbor(int neighbor) {
        graph.onDfsAlreadyVisited(neighbor);
    }

    private void finishVertex(int vertex) {
        graph.onDfsReturn(vertex);
    }
}

