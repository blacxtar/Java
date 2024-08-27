public class ChainedMatrix {
    public static void order(int i, int j, int[][] p, int n) {
        if (i == j) {
            System.out.println("A" + i);
        } else {
            int k = p[i][j];
            System.out.println("(");
            order(i, k, p, n);
            order(k + 1, j, p, n);
            System.out.println(")");
        }

    }

    public static int minMul(int[] O, int[][] p, int n) {
        int M[][] = new int[n + 1][n + 1];

        for (int d = 1; d < n; d++) {
            for (int i = 1; i < n - d; i++) {
                int j = i + d;
                M[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = M[i][k] + M[k + 1][j] + O[i - 1] * O[k] * O[j];
                    if (q < M[i][j]) {
                        M[i][j] = q;
                        p[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Matrix M : ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(M[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix p : ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(p[i][j] + " ");
            }
            System.out.println();
        }
        order(1, 4, p, n);
        System.out.println();
        return M[1][n];
    }

}
