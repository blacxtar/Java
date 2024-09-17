
public class GraphIsomorphism {

    // Variables to store the graphs
    int[][] Gp; // Adjacency matrix of Gp
    int[][] Gd; // Adjacency matrix of Gd
    int[] embedding; // The embedding of vertices from Gp to Gd
    boolean[] used; // Tracks which vertices in Gd are already used

    public GraphIsomorphism(int[][] Gp, int[][] Gd) {
        this.Gp = Gp;
        this.Gd = Gd;
        this.embedding = new int[Gp.length];
        this.used = new boolean[Gd.length];
    }

    // Main backtracking function to find embeddings
    public void getEmbedding(int i) {
        // Base case: If we've embedded all vertices from Gp
        if (i == Gp.length) {
            printEmbedding(); // Print the valid embedding
            return;
        }

        // Try every vertex in Gd for the current vertex in Gp
        for (int j = 0; j < Gd.length; j++) {
            if (!used[j]) { // Check if this vertex in Gd is not yet used
                embedding[i] = j; // Assign Gp[i] to Gd[j]
                used[j] = true;

                // Check if the embedding is valid (promising)
                if (isPromising(i)) {
                    getEmbedding(i + 1); // Recur for the next vertex
                }

                // Backtrack
                used[j] = false;
            }
        }
    }

    // Helper function to check if the current partial embedding is valid
    public boolean isPromising(int i) {
        for (int k = 0; k < i; k++) {
            if (Gp[k][i] == 1 && Gd[embedding[k]][embedding[i]] != 1) {
                return false; // Edge in Gp doesn't match the edge in Gd
            }
        }
        return true; // If no violations, it's promising
    }

    // Helper function to print the valid embedding
    public void printEmbedding() {
        System.out.print("Embedding: ");
        for (int i = 0; i < embedding.length; i++) {
            System.out.print(embedding[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example graphs Gp and Gd
        int[][] Gp = {
                { 0, 1, 0, 0 },
                { 1, 0, 1, 1 },
                { 0, 1, 0, 1 },
                { 0, 1, 1, 0 },
        };

        int[][] Gd = {
                { 0, 1, 1, 0 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 0, 0, 1, 0 }
        };

        GraphIsomorphism gi = new GraphIsomorphism(Gp, Gd);
        gi.getEmbedding(0); // Start backtracking from vertex 0 of Gp
    }
}
