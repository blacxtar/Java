public class BinaryCoefficient {
    // Normal recursion
    public static int bin(int n , int k){
        if (k==0 || k == n) { 
            return 1;
            
        }else {
            return bin(n-1,k-1) + bin(n-1, k);
        }
    }

    // Using triangle matrix for tabulation
    // /Dynamic programming method to compute nCk using a triangular matrix
    public static long bin3(int n, int k) {
        long[][] dp = new long[n + 1][];
        for(int i=0 ; i<=n ; i++){
            dp[i]=new long[i+1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }
  // trapezium
    public static long bin4(int n, int k) {
        long[][] dp = new long[n + 1][];
        for(int i=0 ; i<=n ; i++){
            dp[i]=new long[Math.min(i,k)+1];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }
    

     // Normal method to compute nCk
     public static long nCkNormal(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
    
    public static void main(String[] args) {
    //   System.out.println(bin(5,3));  
      System.out.println(bin3(5,3));  
    }
    
}
