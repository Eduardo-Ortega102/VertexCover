import java.util.*;

public class Graph {

    final protected Map<Integer, Set<Integer>> adjacencyList;
    protected int amountOfEdges;

    /**
     * Initialize an empty graph
     */
    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.amountOfEdges = 0;
    }

    /**
     * Creates a random connected graph of a given number of vertices and edges
     * @param vertices The number of vertices
     * @param edges The number of edges to be randomly created.
     * @param r The random object to be used
     */
    public Graph(int vertices, int edges, Random r) {
        this(vertices);

        for (int vertex = 1; vertex < vertices; vertex++) {
            addEdge(vertex, r.nextInt(vertex));
        }

        for (int vertex = vertices; vertex < edges; vertex++) {
            addEdge(r.nextInt(vertices), r.nextInt(vertices));
        }
    }


    /**
     * Initialize a graph with vertices from 1 to size
     * @param size The number of initial vertices
     */
    public Graph(int size) {
        this();

        if (size < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < size; i++) {
            addVertex(i);
        }
    }

    /**
     * Construct a graph which is a copy of the given graph
     * @param g The graph to be copied
     */
    public Graph(Graph g) {
        this();

        for (int v : g.getAllVertices()) {
            this.addVertex(v);
        }

        //TODO: make more efficient
        for (int v : g.getAllVertices()) {
            for (int u : g.getNeighbors(v)) {
                addEdge(v, u);
            }
        }
    }

    /**
     * Add new vertex to the graph.
     *
     * @param v The vertex object.
     */
    public boolean addVertex(int v) {
        if (this.adjacencyList.containsKey(v)) {
            //Or throw exception??
            return false;
        }

        this.adjacencyList.put(v, new HashSet<>());
        return true;
    }

    /**
     * Add new edge between vertex. Adding new edge from u to v will
     * automatically add new edge from v to u since the graph is undirected.
     *
     * @param v Start vertex.
     * @param u Destination vertex.
     */
    public boolean addEdge(int v, int u) {
        checkVertex(v);
        checkVertex(u);

        if (isAdjacent(v, u)) return false;

        this.adjacencyList.get(v).add(u);
        this.adjacencyList.get(u).add(v);
        amountOfEdges++;
        return true;
    }


    /**
     * Remove the edge between vertex. Removing the edge from u to v will
     * automatically remove the edge from v to u since the graph is undirected.
     *
     * @param v Start vertex.
     * @param u Destination vertex.
    public boolean removeEdge(int v, int u) {

        this.adjacencyList.get(v).remove(u);

        try {
            this.adjacencyList.get(u).remove(v);
        } catch (NullPointerException e) {
            //This happens on self loops
            //Ignore
        }

        amountOfEdges--;
        return true;
    }
                */

    /**
     * Check adjacency between 2 vertices in the graph.
     *
     * @param v Start vertex.
     * @param u Destination vertex.
     * @return <tt>true</tt> if the vertex v and u are connected.
     */
    public boolean isAdjacent(int v, int u) {
        return this.adjacencyList.get(v).contains(u);
    }

    /**
     * Get connected vertices of a vertex.
     *
     * @param v The vertex.
     * @return An iterable for connected vertices.
     */
    public Iterable<Integer> getNeighbors(int v) {
        return this.adjacencyList.get(v);
    }

    /**
     * Get the number of connected vertices of a vertex
     *
     * @param v The vertex.
     * @return The number of adjacent vertices.
     */
    public int getDegree(int v) {
        checkVertex(v);
        return this.adjacencyList.get(v).size();
    }

    /**
     * Get all vertices in the graph.
     *
     * @return An Iterable for all vertices in the graph.
     */
    public Iterable<Integer> getAllVertices() {
        return this.adjacencyList.keySet();
    }

    /**
     * Check if the graph is empty.
     * @return true if the graph doesn't contain any vertex.
     */
    public boolean isEmpty() {
        return this.adjacencyList.keySet().isEmpty();
    }

    /**
     * Return the number of vertices in the graph.
     * @return the size of the graph
     */
    public int size() {
        return this.adjacencyList.keySet().size();
    }

    /**
     * Return the number of amountOfEdges in the graph.
     * @return the amountOfEdges in the the graph
     */
    public int edges() {
        return amountOfEdges;
    }

    /**
     * Check if given vertex is contained in the graph
     * @param v The vertex
     * @return true if the vertex is contained in the graph
     */
    public boolean containsVertex(int v) {
        return this.adjacencyList.containsKey(v);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Graph graph = (Graph) other;
        if (amountOfEdges != graph.edges()) return false;
        return adjacencyList.equals(graph.adjacencyList);
    }

    @Override
    public String toString() {
        return "Graph { " + size() + " vertices; " + edges() + " amountOfEdges }";
    }

    private void checkVertex(int v) {
        if (!containsVertex(v))
            throw new IndexOutOfBoundsException();
    }
}