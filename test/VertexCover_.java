import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class VertexCover_ {

    Random r = new Random(1000);

    @Test
    public void should_test_valid_cover() throws Exception {

        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(1,5);

        ArrayList<Integer> cover = new ArrayList<Integer>();
        cover.add(1);
        cover.add(2);


        assertTrue(VertexCover.isValidCover(g, cover));

    }

    @Test
    public void should_test_vertex_cover() throws Exception {
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(1,5);

        Collection<Integer> cover = VertexCover.cover(g);

        assertTrue(VertexCover.isValidCover(g, cover));

    }


    @Test
    public void should_test_vertex_cover2() throws Exception {

        for (int i = 1; i <= 10; i++) {
            Graph g = new Graph(100*i, 130*i, r);
            Collection<Integer> cover = VertexCover.cover(g);
            assertTrue(VertexCover.isValidCover(g, cover));
        }

    }
}
