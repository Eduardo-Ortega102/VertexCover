import java.util.Collection;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Graph g;

        //Star
        g = new Graph(5);
        for (int i = 1; i < g.size(); i++) {
            g.addEdge(0, i);
        }

        check(g, 1);

//        http://mathworld.wolfram.com/images/eps-gif/MaximumIndependentSet_1000.gif
        g = new Graph(8);
        for (int i = 1; i < g.size(); i++) {
            g.addEdge(0,i);
        }
        for (int i = 1; i < g.size()-1; i++) {
            g.addEdge(i, i+1);
        }
        g.addEdge(1, 7);

        check(g, 3);

        g = new Graph(6);
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                g.addEdge(i, j);
            }
        }

        check (g, 3);

        g = new Graph(10);

        for (int i = 0; i <= 4; i++) {
            //external circle
            g.addEdge(i, (i+1) % 5);
            //radiant edges
            g.addEdge(i, i+5);
            //internal star
            g.addEdge(i+5, ((i+7)%5)+5);
        }
        check(g, 4);

        g = new Graph(12);

        g.addEdge(0,1);
        g.addEdge(0,6);
        g.addEdge(0,8);
        g.addEdge(1,2);
        g.addEdge(1,8);
        g.addEdge(2,3);
        g.addEdge(2,10);
        g.addEdge(3,4);
        g.addEdge(3,11);
        g.addEdge(4,5);
        g.addEdge(4,11);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,7);
        g.addEdge(7,9);
        g.addEdge(8,9);
        g.addEdge(9,10);
        g.addEdge(10,11);

        check(g, 5);
    }

    private static void check(Graph g, int optimalCoverSize) {
        System.out.println("Graph size: " + g.size());
        Collection<Integer> cover = VertexCover.cover(g);
        System.out.println("Cover: " + cover);
        System.out.println("Cover size: " + cover.size() + "\t <=");
        System.out.println("Optimal cover size: " + optimalCoverSize);

        if (cover.size() > 2*optimalCoverSize) {
            System.out.println("The cover is bigger than twice the optimal cover size");
        } else {
            System.out.println("size <= 2*optimal_size: " + cover.size() + " <= 2*" + optimalCoverSize + " = " + 2*optimalCoverSize );
        }
        System.out.println("Check if cover is valid: " + VertexCover.isValidCover(g, cover));
        System.out.println("");
    }
}
