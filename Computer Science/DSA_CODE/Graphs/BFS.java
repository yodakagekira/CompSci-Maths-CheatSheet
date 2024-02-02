import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchPaths {

    private boolean[] visited; // Tracks visited vertices
    private int[] edgeTo; // Records the last edge on a path to a vertex
    private final int source; // Source vertex for paths

    // Constructor initializes data structures and starts the BFS from the source
    public BreadthFirstSearchPaths(Graph g, int s) {
        visited = new boolean[g.numVertices()];
        edgeTo = new int[g.numVertices()];
        this.source = s;
        bfs(g, s);
    }

    // Breadth-first search
    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true; // Mark the source as visited
        queue.offer(s); // Enqueue the source

        while (!queue.isEmpty()) {
            int v = queue.poll(); // Dequeue the next vertex
            System.out.print(v + " "); // Print the vertex as it's visited for traversal purposes
            
            for (int w : g.adj(v)) {
                if (!visited[w]) {
                    edgeTo[w] = v; // Save the last edge on a path to this vertex
                    visited[w] = true; // Mark the vertex as visited
                    queue.offer(w); // Enqueue the vertex
                }
            }
        }
    }

    // Check if there's a path to v
    public boolean hasPathTo(int v) {
        return visited[v];
    }

    // Return the path from the source to the given vertex v
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        Graph g = new Graph(7); // Example graph construction
        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        System.out.println(g);

        BreadthFirstSearchPaths searchPaths = new BreadthFirstSearchPaths(g, 0);
        System.out.println(); // New line after traversal output

        // Demonstrate path finding
        for (int v = 0; v < g.numVertices(); v++) {
            if (searchPaths.hasPathTo(v)) {
                System.out.print("Path from " + searchPaths.source + " to " + v + ": ");
                for (int x : searchPaths.pathTo(v)) {
                    if (x == searchPaths.source) System.out.print(x);
                    else System.out.print("->" + x);
                }
                System.out.println();
            }
        }
    }
}
