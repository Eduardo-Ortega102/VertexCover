
import java.util.*;

public class Graph {
    private final int amountOfVertex;
    private final SortedSet<Edge> edges;
    private List<Edge> mst = null;

    public Graph(int size) {
        if (size < 0)
            throw new IllegalArgumentException("size(" + size + "): the size of a graph must be greater or equal than 0");
        this.amountOfVertex = size;
        edges = new TreeSet<>(Comparator.naturalOrder());
    }

    public boolean addEdge(int vertex1, int vertex2) {
        checkBounds(vertex1);
        checkBounds(vertex2);
        Edge edge = new Edge(vertex1, vertex2);
        mst = null;
        return edges.add(edge);
    }

    public int amountOfVertex() {
        return amountOfVertex;
    }

    public int amountOfEdges() {
        return edges.size();
    }

    public List<Edge> edges() {
        List<Edge> edges = new ArrayList<>(this.edges.size());
        for (Edge edge : this.edges) edges.add(edge);
        return edges;
    }

    private void checkBounds(int vertex) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("vertex(" + vertex + "): is out of range {-}");
        if (!containsVertex(vertex))
            throw new IndexOutOfBoundsException("vertex(" + vertex + "): is out of range {0.." + (amountOfVertex - 1) + "}");
    }

    public boolean containsVertex(int vertex) {
        return vertex >= 0 && vertex < amountOfVertex;
    }

    public boolean isEmpty() {
        return amountOfVertex == 0;
    }

    @Override
    public String toString() {
        return "Graph { " + amountOfVertex + " vertices; " + amountOfEdges() + " edges }";
    }
}
