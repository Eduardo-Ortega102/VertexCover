import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class Graph_ {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_not_create_a_graph_with_less_than_0_vertex() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("size(-1): the size of a graph must be greater or equal than 0");
        new Graph(-1);
    }

    @Test
    public void should_create_an_empty_graph() throws Exception {
        Graph graph = new Graph(0);
        assertTrue(graph.isEmpty());
        assertEquals(graph.amountOfVertex(), 0);
        assertEquals(graph.amountOfEdges() , 0);
        assertFalse(graph.containsVertex(-1));
        assertFalse(graph.containsVertex(0));
        assertFalse(graph.containsVertex(1));
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("vertex(0): is out of range {-}");
        graph.addEdge(0, 0);
    }

    @Test
    public void should_create_a_graph_of_a_given_size() throws Exception {
        int size = 5;
        Graph graph = new Graph(size);
        assertEquals(graph.amountOfVertex()    , size);
        assertFalse(graph.containsVertex(size));
        assertFalse(graph.containsVertex(-1)  );
        for (int vertex = 0; vertex < size; vertex++)
            assertTrue(graph.containsVertex(vertex));
    }

    @Test
    public void should_add_edges_between_existing_vertices() throws Exception {
        Graph graph = new Graph(3);
        assertTrue(graph.addEdge(0, 0));
        assertTrue(graph.addEdge(0, 1));
        assertTrue(graph.addEdge(0, 2));
        assertTrue(graph.addEdge(1, 2));
        assertEquals(4, graph.amountOfEdges());
    }

    @Test
    public void should_not_add_an_edge_if_already_exists() throws Exception {
        Graph graph = new Graph(3);
        assertTrue(graph.addEdge(0, 1));
        assertFalse(graph.addEdge(0, 1));
        assertFalse(graph.addEdge(0, 1));
        assertEquals(graph.amountOfEdges(), 1);
    }


    @Test
    public void should_not_add_edges_if_a_vertex_not_exists() throws Exception {
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("vertex(10): is out of range {0..6}");
        new Graph(7).addEdge(0, 10);
    }

    @Test
    public void summary_of_a_graph() throws Exception {
        Graph graph = new Graph(3);
        assertEquals("Graph { 3 vertices; 0 edges }",  graph.toString());
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        assertEquals("Graph { 3 vertices; 4 edges }", graph.toString());
    }

    private Edge edge(int vertex1, int vertex2, double weight) {
        return new Edge(vertex1, vertex2);
    }

    private List<Edge> expectedList(Edge... edges) {
        return Arrays.asList(edges);
    }

    private TreeSet<Edge> expectedTree(Edge... edges) {
        TreeSet<Edge> s = new TreeSet<>();
        for (Edge e : edges)
            s.add(e);
        return s;
    }

}