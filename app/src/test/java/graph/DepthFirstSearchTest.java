package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DepthFirstSearchTest {

    @Test
    public void testConstructorNullGraph() {
        assertThrows(IllegalArgumentException.class, () -> new DepthFirstSearch(null));
    }

    @Test
    public void testDfsSimpleChain() {
        TracingGraph graph = new TracingGraph(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(1);
        List<String> actualTrace = graph.getTrace();

        List<String> expectedTrace = List.of(
                "T1:start:1",
                "T2:visit:1",
                "T3:edge:1->2",
                "T2:visit:2",
                "T3:edge:2->1",
                "T4:alreadyVisited:1",
                "T3:edge:2->3",
                "T2:visit:3",
                "T3:edge:3->2",
                "T4:alreadyVisited:2",
                "T5:return:3",
                "T5:return:2",
                "T5:return:1"
        );

        assertEquals(expectedTrace, actualTrace);
    }

    @Test
    public void testDfsBranchingTree() {
        TracingGraph graph = new TracingGraph(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(1);
        List<String> actualTrace = graph.getTrace();

        List<String> expectedTrace = List.of(
                "T1:start:1",
                "T2:visit:1",
                "T3:edge:1->2",
                "T2:visit:2",
                "T3:edge:2->1",
                "T4:alreadyVisited:1",
                "T3:edge:2->4",
                "T2:visit:4",
                "T3:edge:4->2",
                "T4:alreadyVisited:2",
                "T5:return:4",
                "T5:return:2",
                "T3:edge:1->3",
                "T2:visit:3",
                "T3:edge:3->1",
                "T4:alreadyVisited:1",
                "T5:return:3",
                "T5:return:1"
        );

        assertEquals(expectedTrace, actualTrace);
    }

    @Test
    public void testDfsCycleTriangle() {
        TracingGraph graph = new TracingGraph(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(1);
        List<String> actualTrace = graph.getTrace();

        List<String> expectedTrace = List.of(
                "T1:start:1",
                "T2:visit:1",
                "T3:edge:1->2",
                "T2:visit:2",
                "T3:edge:2->1",
                "T4:alreadyVisited:1",
                "T3:edge:2->3",
                "T2:visit:3",
                "T3:edge:3->2",
                "T4:alreadyVisited:2",
                "T3:edge:3->1",
                "T4:alreadyVisited:1",
                "T5:return:3",
                "T5:return:2",
                "T3:edge:1->3",
                "T4:alreadyVisited:3",
                "T5:return:1"
        );

        assertEquals(expectedTrace, actualTrace);
    }

    @Test
    public void testDfsSingleVertex() {
        TracingGraph graph = new TracingGraph(true);
        graph.addVertex(1);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(1);
        List<String> actualTrace = graph.getTrace();

        List<String> expectedTrace = List.of(
                "T1:start:1",
                "T2:visit:1",
                "T5:return:1"
        );

        assertEquals(expectedTrace, actualTrace);
    }

    @Test
    public void testDfsOnEmptyGraph() {
        TracingGraph graph = new TracingGraph(true);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(1);
        List<String> actualTrace = graph.getTrace();

        List<String> expectedTrace = List.of(
                "T1:start:1",
                "T2:visit:1",
                "T5:return:1"
        );

        assertEquals(expectedTrace, actualTrace);
    }

    @Test
    public void testDfsOnDisconnectedGraph() {
        TracingGraph graph = new TracingGraph(true);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs(3);
        List<String> actualTrace = graph.getTrace();

        List<String> expectedTrace = List.of(
                "T1:start:3",
                "T2:visit:3",
                "T3:edge:3->4",
                "T2:visit:4",
                "T3:edge:4->3",
                "T4:alreadyVisited:3",
                "T5:return:4",
                "T5:return:3"
        );

        assertEquals(expectedTrace, actualTrace);
    }
}

