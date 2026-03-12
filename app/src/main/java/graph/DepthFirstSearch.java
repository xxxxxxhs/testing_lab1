package graph;

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

    public void dfs(int start, List<String> trace) {
        Set<Integer> visited = new HashSet<>();
        trace.add("T1:start:" + start);
        dfsRecursive(start, visited, trace);
    }

    private void dfsRecursive(int vertex, Set<Integer> visited, List<String> trace) {
        trace.add("T2:visit:" + vertex);
        visited.add(vertex);

        for (int neighbor : graph.getNeighbors(vertex)) {
            trace.add("T3:edge:" + vertex + "->" + neighbor);
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, trace);
            } else {
                trace.add("T4:alreadyVisited:" + neighbor);
            }
        }

        trace.add("T5:return:" + vertex);
    }
}

