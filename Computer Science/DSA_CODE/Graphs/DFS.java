import java.util.Stack;

public class DepthFirstSearchPaths {

    private boolean[] visited; // Tracks visited vertices
    private int[] edgeTo; // Last vertex on known path to this vertex
    private final int source; // Source vertex

    // Constructor initializes data structures and starts the DFS from the source
    public DepthFirstSearchPaths(Graph g, int s) {
        visited = new boolean[g.numVertices()];
        edgeTo = new int[g.numVertices()];
        this.source = s;
        dfs(g, s);
    }

    // Depth-first search
    private void dfs(Graph g, int v) {
        visited[v] = true;
        System.out.print(v + " ");  // Print the vertex as it's visited for traversal purposes
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                edgeTo[w] = v; // Save the last edge on a path to this vertex
                dfs(g, w);
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
        path.push(source); // Include the source itself in the path
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

        DepthFirstSearchPaths searchPaths = new DepthFirstSearchPaths(g, 0);
        System.out.println(); // New line after traversal output

        // Demonstrate path finding
        for (int v = 0; v < g.numVertices(); v++) {
            if (searchPaths.hasPathTo(v)) {
                System.out.print("Path from 0 to " + v + ": ");
                for (int x : searchPaths.pathTo(v)) {
                    if (x == 0) System.out.print(x);
                    else System.out.print("-" + x);
                }
                System.out.println();
            }
        }
    }
}
