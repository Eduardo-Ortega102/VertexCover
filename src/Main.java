import java.util.Collection;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Graph g = new Graph(100, 10000, new Random());

        System.out.println(g.fullString());

        Collection<Integer> cover = VertexCover.cover(g);
        System.out.println("Cover: " + cover);
        System.out.println("Cover size: " + cover.size());

        System.out.println("Check if cover is valid: " + VertexCover.isValidCover(g, cover));

    }
}
