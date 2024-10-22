// Directed Graph using Adjacency Matrix
class DirectedGraph {
    private int[][] adjacencyMatrix;
    private int vertices;

    // Constructor to initialize the graph with the given number of vertices
    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Method to add an edge from vertex u to vertex v
    public void addEdge(int u, int v) {
        if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
            adjacencyMatrix[u][v] = 1; // Set matrix[u][v] to 1 to indicate an edge
            System.out.println("Edge added from " + u + " to " + v);
        } else {
            System.out.println("Invalid vertices");
        }
    }

    // Method to delete an edge from vertex u to vertex v
    public void deleteEdge(int u, int v) {
        if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
            adjacencyMatrix[u][v] = 0; // Set matrix[u][v] to 0 to remove the edge
            System.out.println("Edge deleted from " + u + " to " + v);
        } else {
            System.out.println("Invalid vertices");
        }
    }

    // Method to print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5); // Create a graph with 5 vertices

        // Adding edges
        graph.addEdge(0, 1); // Edge from 0 to 1
        graph.addEdge(0, 2); // Edge from 0 to 2
        graph.addEdge(1, 3); // Edge from 1 to 3
        graph.addEdge(3, 4); // Edge from 3 to 4

        // Print the adjacency matrix
        graph.printGraph();

        // Deleting an edge
        graph.deleteEdge(0, 2); // Remove edge from 0 to 2

        // Print the adjacency matrix after deletion
        graph.printGraph();
    }
}
