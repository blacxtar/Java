import java.util.Scanner;

public class SumOfSubset {
    static int[] weights;
    static int n;
    static int W;
    static boolean[] include;

    public static boolean isPromising(int i, int weight, int total) {
        return (weight + total >= W) && (weight <= W);
    }

    public static int sum(int arr[]) {
        int sum = 0;
        for (int elements : arr) {
            sum += elements;
        }
        return sum;
    }

    public static void sumOfSubset(int i, int weight, int total) {
        if (isPromising(i, weight, total)) {
            if (weight == W) {
                for (int j = 0; i < include.length; i++) {
                    System.out.print(include[j] + " ");
                }
            } else {
                if (i + 1 < n) {
                    include[i + 1] = true;
                    sumOfSubset(i + 1, weight + weights[i + 1], total - weights[i + 1]);
                    include[i + 1] = false;
                    sumOfSubset(i + 1, weight, total - weights[i + 1]);

                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        weights = new int[n];

        System.out.println("Enter the elements(POSITIVE ONLY ) : ");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum (W) : ");
        W = sc.nextInt();

        include = new boolean[n];
        sumOfSubset(0, 0, sum(weights));

        sc.close();

    }

}
