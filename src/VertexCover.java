import java.util.*;

public class VertexCover {

    public List<Integer> cover(Graph graph) {
        List<Integer> vertices = new ArrayList<>();
        Graph copy = new Graph(graph);
        for (Edge edge : copy) {
            vertices.add(edge.lowVertex());
            vertices.add(edge.highVertex());
            copy.removeVertex(edge.lowVertex());
            copy.removeVertex(edge.highVertex());
        }
        return vertices;
    }

}
