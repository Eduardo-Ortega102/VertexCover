import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Edge_ {
 /*   @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void should_throw_an_exception_if_a_vertex_is_lower_than_zero() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("vertex(-1): Vertices must not be negative");
        new Edge(1, -1);
    }

    @Test
    public void should_return_the_other_vertex_when_one_is_given() throws Exception {
        Edge edge = new Edge(1, 3);
        assertEquals(edge.otherVertex(1), 3);
        assertEquals(edge.otherVertex(3), 1);
    }

    @Test
    public void should_throw_an_exception_if_a_vertex_is_not_inside_the_edge() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("vertex(32): This vertex is not inside the edge");
        new Edge(1, 3).otherVertex(32);
    }

    @Test
    public void vertices_on_edges_are_ordered_from_low_to_high() throws Exception {
        assertEquals(new Edge(9, 5).toString(), "Edge {5,9} weight {3.0}");
        assertEquals(new Edge(5, 9).toString(), "Edge {5,9} weight {3.0}");
        assertEquals(new Edge(3, 3).toString(), "Edge {3,3} weight {3.0}");
    }

    @Test
    public void should_know_if_contains_a_loop() throws Exception {
        assertTrue(new Edge(1, 1, 7.0).isLoop());
        assertTrue(new Edge(1, 1, 7.0).isLoop());
        assertFalse(new Edge(1, 10, 7.0).isLoop());
        assertFalse(new Edge(1, 10, 7.0).isLoop());
    }


    @Test
    public void edges_with_the_same_weight_and_vertices_are_equal() throws Exception {
        int vertex1 = 1, vertex2 = 2;
        assertEquals(new Edge(vertex1, vertex2, 9.0), new Edge(vertex1, vertex2, 9.0));
        assertEquals(new Edge(vertex1, vertex2, 9.0), new Edge(vertex2, vertex1, 9.0));
    }

    @Test
    public void edges_with_distinct_weight_and_same_vertices_are_not_equal() throws Exception {
        int vertex1 = 1, vertex2 = 2;
        assertNotEquals(new Edge(vertex1, vertex2, 9.0), new Edge(vertex1, vertex2, 12.0));
    }

    @Test
    public void edges_with_distinct_vertices_are_not_equal() throws Exception {
        double weight = 9;
        assertNotEquals(new Edge(1, 2, weight), new Edge(1, 1, weight));
    }

    @Test
    public void should_order_edges_by_weight_from_low_to_high() throws Exception {
        assertEquals(orderList(edge(5.0), edge(5.0), edge(5.0)), expectedList(edge(5.0), edge(5.0), edge(5.0)));
        assertEquals(orderList(edge(3.9), edge(3.2), edge(3.0)), expectedList(edge(3.0), edge(3.2), edge(3.9)));
        assertEquals(orderList(edge(9.0), edge(9.0), edge(5.0)), expectedList(edge(5.0), edge(9.0), edge(9.0)));
        assertEquals(orderList(edge(9.0), edge(9.5), edge(5.0)), expectedList(edge(5.0), edge(9.0), edge(9.5)));
        assertEquals(orderList(edge(2.0), edge(9.0), edge(69.0)), expectedList(edge(2.0), edge(9.0), edge(69.0)));
    }

    private Edge edge(double weight) {
        return new Edge(1, 1, weight);
    }

    private List<Edge> expectedList(Edge... edges) {
        return Arrays.asList(edges);
    }

    private List<Edge> orderList(Edge... edges) {
        List<Edge> list = Arrays.asList(edges);
        Collections.sort(list);
        return list;
    }*/
}














