
import java.util.*;

public class Graph implements Iterable<Edge>{
    private int amountOfEdges;
    private Map<Integer, Set<Integer>> vertices;

    public Graph(int size) {
        if (size < 0)
            throw new IllegalArgumentException("size(" + size + "): the size of a graph must be greater or equal than 0");
        amountOfEdges = 0;
        vertices = new HashMap<>(size);
        for (int vertex = 0; vertex < size; vertex++)
            vertices.put(vertex, new HashSet<>());
    }

    public Graph(Graph graph) {
        this(graph.amountOfVertex());
        for (Integer vertex : vertices.keySet())
            vertices.get(vertex).addAll(graph.vertices.get(vertex));
        amountOfEdges = graph.amountOfEdges;
    }

    public boolean addEdge(int vertex1, int vertex2) {
        checkBounds(vertex1);
        checkBounds(vertex2);
        if (vertices.get(vertex1).contains(vertex2)) return false;
        vertices.get(vertex1).add(vertex2);
        vertices.get(vertex2).add(vertex1);
        amountOfEdges++;
        return true;
    }

    public int amountOfVertex() {
        return vertices.size();
    }

    public int amountOfEdges() {
        return amountOfEdges;
    }

    private void checkBounds(int vertex) {
        if (isEmpty())
            throw new IndexOutOfBoundsException("vertex(" + vertex + "): is out of range {-}");
        if (!containsVertex(vertex))
            throw new IndexOutOfBoundsException("vertex(" + vertex + "): is not inside the graph");
    }

    public boolean containsVertex(int vertex) {
        return vertices.containsKey(vertex);
    }

    public boolean isEmpty() {
        return amountOfVertex() == 0;
    }

    @Override
    public String toString() {
        return "Graph { " + amountOfVertex() + " vertices; " + amountOfEdges() + " edges }";
    }

    public boolean removeVertex(int target) {
        if (!containsVertex(target)) return false;
        Set<Integer> relatedVertices = vertices.remove(target);
        for (int vertex : relatedVertices)
            if (vertex != target) vertices.get(vertex).remove(target);
        amountOfEdges -= relatedVertices.size();
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Graph graph = (Graph) other;
        if (amountOfEdges != graph.amountOfEdges) return false;
        return vertices.equals(graph.vertices);
    }


    @Override
    public Iterator<Edge> iterator() {
        return new Iterator<Edge>() {
            private final Random random = new Random();

            @Override
            public boolean hasNext() {
                return amountOfEdges > 0;
            }

            @Override
            public Edge next() {
                List<Integer> keys = new ArrayList<>(vertices.keySet());
                int origin = keys.get(random.nextInt(keys.size()));
                Set<Integer> destinations = vertices.get(origin);
                return new Edge(origin, destinations.iterator().next());
            }
        };
    }
}
