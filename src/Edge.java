import static java.lang.Integer.compare;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Edge implements Comparable<Edge> {
    private final int lowVertex;
    private final int highVertex;

    public Edge(int vertex1, int vertex2) {
        if (vertex1 < 0)
            throw new IllegalArgumentException("vertex(" + vertex1 + "): Vertices must not be negative");
        if (vertex2 < 0)
            throw new IllegalArgumentException("vertex(" + vertex2 + "): Vertices must not be negative");
        this.lowVertex  = min(vertex1, vertex2);
        this.highVertex = max(vertex1, vertex2);
    }

    public int lowVertex() {
        return lowVertex;
    }

    public int highVertex() {
        return highVertex;
    }

    public boolean isLoop() {
        return lowVertex == highVertex;
    }

    @Override
    public String toString() {
        return "Edge {" + lowVertex + "," + highVertex + "}";
    }

    @Override
    public boolean equals(Object obj) {
        Edge edge = (Edge) obj;
        return lowVertex == edge.lowVertex && highVertex == edge.highVertex;
    }

    @Override
    public int compareTo(Edge edge) {
        return compare(lowVertex, edge.lowVertex) != 0 ? compare(lowVertex, edge.lowVertex) : compare(highVertex, edge.highVertex);
    }

    public boolean containsVertexOf(Edge target) {
        //TODO
        return false;
    }
}