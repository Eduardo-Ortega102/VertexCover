import java.util.*;

/**
 * EdgeGraph adds functionality to a simple graph, by allowing edge and vertex removal
 * and by keeping a cached and iterable set of edges
 */
public class EdgeGraph extends Graph implements Iterable<Edge> {

    private SortedSet<Edge> edges = new TreeSet<>();

    /**
     * Construct an EdgeGraph which is a copy of a Graph
     * @param g The graph to be copied
     */
    public EdgeGraph(Graph g) {
        super();

        for (int v : g.getAllVertices()) {
            this.addVertex(v);
        }

        for (int v : g.getAllVertices()) {
            for (int u : g.getNeighbors(v)) {
                addEdge(v, u);
            }
        }
    }

    public EdgeGraph(int size) {
        super(size);
    }

    @Override
    public boolean addEdge(int v, int w) {
        this.edges.add(new Edge(v, w));
        return super.addEdge(v, w);
    }

    private boolean removeEdge(int v, int u) {
        try {
            this.adjacencyList.get(v).remove(u);
        } catch (Exception e) {}

        try {
            this.adjacencyList.get(u).remove(v);
        } catch (Exception e) {}

        return this.edges.remove(new Edge(v, u));
    }

    /**
     * Remove the specified vertex
     * @param v
     * @return
     */
    public boolean removeVertex(int v) {
        if (!containsVertex(v))
            return false;

        Set<Integer> relatedVertices = adjacencyList.remove(v);
        for (int u : relatedVertices) {
            removeEdge(u, v);
        }
        amountOfEdges -= relatedVertices.size();

        assert amountOfEdges == edges.size();
        return true;
    }

    /**
     * Iterate through all the edges in the graph
     * @return
     */
    @Override
    public Iterator<Edge> iterator() {
        return new Iterator<Edge>() {
            @Override
            public boolean hasNext() {
                return edges.iterator().hasNext();
            }

            @Override
            public Edge next() {
                return edges.iterator().next();
            }
        };
    }
}
