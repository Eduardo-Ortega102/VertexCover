import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Edge_ {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_throw_an_exception_if_a_vertex_is_lower_than_zero() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("vertex(-1): Vertices must not be negative");
        new Edge(1, -1);
    }

    @Test
    public void vertices_on_edges_are_ordered_from_low_to_high() throws Exception {
        assertEquals(new Edge(9, 5).toString(), "Edge {5,9}");
        assertEquals(new Edge(5, 9).toString(), "Edge {5,9}");
        assertEquals(new Edge(3, 3).toString(), "Edge {3,3}");
    }

    @Test
    public void should_know_if_contains_a_loop() throws Exception {
        assertTrue(new Edge(1, 1).isLoop());
        assertTrue(new Edge(1, 1).isLoop());
        assertFalse(new Edge(1, 10).isLoop());
        assertFalse(new Edge(1, 10).isLoop());
    }

    @Test
    public void edges_with_the_same_vertices_are_equal() throws Exception {
        int vertex1 = 1, vertex2 = 2;
        assertEquals(new Edge(vertex1, vertex2), new Edge(vertex1, vertex2));
        assertEquals(new Edge(vertex1, vertex2), new Edge(vertex2, vertex1));
    }

    @Test
    public void edges_with_distinct_vertices_are_not_equal() throws Exception {
        assertNotEquals(new Edge(1, 2), new Edge(1, 1));
    }

    @Test
    public void an_edge_must_know_if_contains_any_vertex_of_another_edge() throws Exception {
        int vertex1 = 1, vertex2 = 3;
        Edge target = new Edge(vertex1, vertex2);
        assertTrue(new Edge(vertex1, vertex1).containsAnyVertexOf(target));
        assertTrue(new Edge(vertex1,9).containsAnyVertexOf(target));
        assertTrue(new Edge(vertex2,5).containsAnyVertexOf(target));
        assertTrue(new Edge(7, vertex2).containsAnyVertexOf(target));
        assertFalse(new Edge(4,7).containsAnyVertexOf(target));
    }
/*
    @Test
    public void should_order_edges_by_weight_from_low_to_high() throws Exception {
        assertEquals(orderList(edge(5.0), edge(5.0), edge(5.0)), expectedList(edge(5.0), edge(5.0), edge(5.0)));
        assertEquals(orderList(edge(3.9), edge(3.2), edge(3.0)), expectedList(edge(3.0), edge(3.2), edge(3.9)));
        assertEquals(orderList(edge(9.0), edge(9.0), edge(5.0)), expectedList(edge(5.0), edge(9.0), edge(9.0)));
        assertEquals(orderList(edge(9.0), edge(9.5), edge(5.0)), expectedList(edge(5.0), edge(9.0), edge(9.5)));
        assertEquals(orderList(edge(2.0), edge(9.0), edge(69.0)), expectedList(edge(2.0), edge(9.0), edge(69.0)));
    }
*/
    private Edge edge(double weight) {
        return new Edge(1, 1);
    }

    private List<Edge> expectedList(Edge... edges) {
        return Arrays.asList(edges);
    }

    private List<Edge> orderList(Edge... edges) {
        List<Edge> list = Arrays.asList(edges);
        Collections.sort(list);
        return list;
    }
}














