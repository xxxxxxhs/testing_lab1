package graph;

import java.util.ArrayList;
import java.util.List;

public class TracingGraph extends Graph {

    private boolean tracingEnabled;
    private final List<String> trace = new ArrayList<>();

    public TracingGraph(boolean tracingEnabled) {
        super();
        this.tracingEnabled = tracingEnabled;
    }

    public void enableTracing() {
        this.tracingEnabled = true;
    }

    public void disableTracing() {
        this.tracingEnabled = false;
    }

    public List<String> getTrace() {
        return trace;
    }

    public void clearTrace() {
        trace.clear();
    }

    @Override
    public void addVertex(int v) {
        if (tracingEnabled) {
            trace.add("GV:addVertex:" + v);
        }
        super.addVertex(v);
    }

    @Override
    public void addEdge(int u, int v) {
        if (tracingEnabled) {
            trace.add("GE:addEdge:" + u + "->" + v);
        }
        super.addEdge(u, v);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        if (tracingEnabled) {
            trace.add("GN:getNeighbors:" + v);
        }
        return super.getNeighbors(v);
    }
}

