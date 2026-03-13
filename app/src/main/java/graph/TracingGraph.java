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
    protected void onDfsStart(int startVertex) {
        if (tracingEnabled) {
            trace.add("T1:start:" + startVertex);
        }
    }

    @Override
    protected void onDfsVisit(int vertex) {
        if (tracingEnabled) {
            trace.add("T2:visit:" + vertex);
        }
    }

    @Override
    protected void onDfsEdge(int from, int to) {
        if (tracingEnabled) {
            trace.add("T3:edge:" + from + "->" + to);
        }
    }

    @Override
    protected void onDfsAlreadyVisited(int vertex) {
        if (tracingEnabled) {
            trace.add("T4:alreadyVisited:" + vertex);
        }
    }

    @Override
    protected void onDfsReturn(int vertex) {
        if (tracingEnabled) {
            trace.add("T5:return:" + vertex);
        }
    }
}


