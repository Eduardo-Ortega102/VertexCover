import java.util.*;

public class VertexCover {

    /**
     * Find an approximated vertex cover for a given graph
     * @param g The graph
     * @return  A collection of vertex representing the cover set.
     */
    public static Collection<Integer> cover(Graph g) {
        Collection<Integer> cover = new TreeSet<>();
        EdgeGraph copy = new EdgeGraph(g);

        for (Edge e : copy) {

            cover.add(e.lowVertex());
            cover.add(e.highVertex());

            copy.removeVertex(e.lowVertex());
            copy.removeVertex(e.highVertex());
        }

        return cover;
    }

    /**
     * Check if the provided cover is a valid cover for the graph
     * @param g     The graph
     * @param cover The collection of vertices in the cover
     * @return True if every edge of g has at least on vertex in cover
     */
    public static boolean isValidCover(Graph g, Collection<Integer> cover) {

        mainLoop:
        for (int v : g.getAllVertices()) {

            if (cover.contains(v)) continue;

            for (int neighbor : g.getNeighbors(v)) {
                if (cover.contains(neighbor))
                    continue mainLoop;
            }
            return false;
        }

        return true;
    }
}
