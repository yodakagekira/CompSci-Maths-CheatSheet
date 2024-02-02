public class Graph {
    private int numVertices;
    private int numEdges;
    private BagArray<Integer>[] adj;

    // create an empty graph with V vertices
    public Graph(int numVertices) {
        initializeEmptyGraph(numVertices);
    }

    @SuppressWarnings("unchecked")
    public void initializeEmptyGraph(int numVertices) {
        this.numVertices = numVertices;
        this.numEdges = 0;

        // Initialize array of bag arrays for adjacency lists
        adj = (BagArray<Integer>[]) new BagArray[numVertices];
        for (int v = 0; v < numVertices; v++) {
            adj[v] = new BagArray<>();
        }
    }

    public void addEdge(int v, int w) {
        numEdges++;
        adj[v].add(w); // Add edge from v to w
        adj[w].add(v); // Since it's an undirected graph, also add edge from w to v
    }

    public Iterable<Integer> adj(int v) {
        return adj[v]; // Return iterable list of all adjacent vertices
    }

    public int numVertices() {
        return this.numVertices;
    }

    public int numEdges() {
        return this.numEdges;
    }

    public int degree(int v) {
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String NEWLINE = System.lineSeparator();
        sb.append(numVertices + " vertices, " + numEdges + " edges " + NEWLINE);
        for (int v = 0; v < numVertices; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(3, 5);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        System.out.println(g);
    }
}
