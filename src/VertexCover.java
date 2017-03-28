import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class VertexCover {

    private final Random random;
    private List<Edge> edges;

    public VertexCover() {
        this.random = new Random();
    }

    public List<Integer> cover(Graph graph) {
        List<Integer> vertices = new ArrayList<>();
        edges = graph.edges();
        while (edges.size() > 0) {
            Edge edge = getRandomEdge();
            vertices.add(edge.lowVertex());
            vertices.add(edge.highVertex());
            edges.removeAll(edgesThatContainsAnyVertexOf(edge));
        }
        return vertices;
    }

    private Edge getRandomEdge() {
        return edges.get(random.nextInt(edges.size()));
    }

    private Collection<Edge> edgesThatContainsAnyVertexOf(Edge target) {
        ArrayList<Edge> list = new ArrayList<>();
        for (Edge edge : edges)
            if (edge.containsVertexOf(target)) list.add(edge);
        return list;
    }


}
