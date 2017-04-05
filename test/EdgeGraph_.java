/**
 * @author afusco
 * @date 04/04/17
 */
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EdgeGraph_ {
    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void should_create_an_empty_graph() throws Exception {
        EdgeGraph graph = new EdgeGraph(0);
        assertTrue(graph.isEmpty());
        assertEquals(graph.size(), 0);
        assertEquals(graph.edges() , 0);
        assertFalse(graph.containsVertex(-1));
        assertFalse(graph.containsVertex(0));
        assertFalse(graph.containsVertex(1));
        exception.expect(IndexOutOfBoundsException.class);
        graph.addEdge(0, 0);
    }

    @Test
    public void should_create_a_graph_of_a_given_size() throws Exception {
        int size = 5;
        EdgeGraph graph = new EdgeGraph(size);
        assertEquals(graph.size()    , size);
        assertFalse(graph.containsVertex(size));
        assertFalse(graph.containsVertex(-1)  );
        for (int vertex = 0; vertex < size; vertex++)
            assertTrue(graph.containsVertex(vertex));
    }

    @Test
    public void should_add_edges_between_existing_vertices() throws Exception {
        EdgeGraph graph = new EdgeGraph(3);
        assertTrue(graph.addEdge(0, 0));
        assertTrue(graph.addEdge(0, 1));
        assertTrue(graph.addEdge(0, 2));
        assertTrue(graph.addEdge(1, 2));
        assertEquals(4, graph.edges());
    }

    @Test
    public void should_not_add_an_edge_if_already_exists() throws Exception {
        EdgeGraph graph = new EdgeGraph(3);
        assertTrue(graph.addEdge(0, 1));
        assertFalse(graph.addEdge(0, 1));
        assertEquals(1, graph.edges());
    }


    @Test
    public void should_not_add_edges_if_a_vertex_not_exists() throws Exception {
        exception.expect(IndexOutOfBoundsException.class);
        new EdgeGraph(7).addEdge(0, 10);
    }

    @Test
    public void should_remove_a_vertex_with_its_edges() throws Exception {
        int size = 3;
        EdgeGraph graph = setupEdgeGraph(size);
        assertEquals(size, graph.size());
        assertEquals(6, graph.edges());
        assertTrue(graph.removeVertex(0));
        assertEquals(size - 1, graph.size());
        assertEquals(3, graph.edges());
    }

    @Test
    public void should_not_remove_a_vertex_if_not_exists() throws Exception {
        int size = 3;
        EdgeGraph graph = setupEdgeGraph(size);
        assertEquals(size, graph.size());
        assertEquals(6, graph.edges());
        assertFalse(graph.removeVertex(9));
        assertEquals(size, graph.size());
        assertEquals(6, graph.edges());
    }

    private EdgeGraph setupEdgeGraph(int size) {
        EdgeGraph graph = new EdgeGraph(size);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 1);
        graph.addEdge(2, 2);
        return graph;
    }

    @Test
    public void should_build_a_copy_by_constructor() throws Exception {
        EdgeGraph graph1 = setupEdgeGraph(3);
        EdgeGraph graph2 = new EdgeGraph(graph1);
        assertFalse(graph1 == graph2);
        assertEquals(graph1, graph2);
    }



    @Test
    public void should_add_vertices() throws Exception {
        EdgeGraph g = new EdgeGraph(0);
        assertEquals(0, g.size());

        assertTrue(g.addVertex(10));
        assertEquals(1, g.size());
        assertTrue(g.containsVertex(10));

        assertFalse(g.addVertex(10));
        assertEquals(1, g.size());
        assertTrue(g.containsVertex(10));

        assertTrue(g.addVertex(-1));
        assertEquals(2, g.size());
    }

    @Test
    public void should_remove_vertices() throws Exception {
        EdgeGraph g = new EdgeGraph(10);

        assertTrue(g.removeVertex(1));
        assertFalse(g.containsVertex(1));
        assertEquals(9, g.size());

        assertFalse(g.removeVertex(1));
        assertFalse(g.containsVertex(1));
    }

    @Test
    public void should_remove_adjacent_edges_when_removing_vertex() throws Exception {

        EdgeGraph g = new EdgeGraph(3);

        g.addEdge(0, 1);
        g.addEdge(0,2);
        assertEquals(2, g.edges());
        assertEquals(3, g.size());
        assertEquals(2, g.getDegree(0));
        assertEquals(1, g.getDegree(1));
        assertEquals(1, g.getDegree(2));

        g.removeVertex(0);
        assertEquals(0, g.edges());
        assertEquals(2, g.size());
        assertEquals(0, g.getDegree(1));
        assertEquals(0, g.getDegree(2));
    }

}
