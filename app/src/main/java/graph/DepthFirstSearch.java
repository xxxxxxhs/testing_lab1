package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {
    private final Graph graph;

    public DepthFirstSearch(Graph graph) {
        if (graph == null) {
            throw new IllegalArgumentException("graph must not be null");
        }
        this.graph = graph;
    }

    public List<String> dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        List<String> trace = new ArrayList<>();
        trace.add("T1:start:" + start);
        dfsRecursive(start, visited, trace);
        return trace;
    }

    private void dfsRecursive(int vertex, Set<Integer> visited, List<String> trace) {
        visitVertex(vertex, visited, trace);
        for (int neighbor : graph.getNeighbors(vertex)) {
            processNeighbor(vertex, neighbor, visited, trace);
        }
        finishVertex(vertex, trace);
    }

    private void visitVertex(int vertex, Set<Integer> visited, List<String> trace) {
        trace.add("T2:visit:" + vertex);
        visited.add(vertex);
    }

    private void processNeighbor(int vertex, int neighbor, Set<Integer> visited, List<String> trace) {
        trace.add("T3:edge:" + vertex + "->" + neighbor);
        if (!visited.contains(neighbor)) {
            dfsRecursive(neighbor, visited, trace);
        } else {
            handleAlreadyVisitedNeighbor(neighbor, trace);
        }
    }

    private void handleAlreadyVisitedNeighbor(int neighbor, List<String> trace) {
        trace.add("T4:alreadyVisited:" + neighbor);
    }

    private void finishVertex(int vertex, List<String> trace) {
        trace.add("T5:return:" + vertex);
    }
}
