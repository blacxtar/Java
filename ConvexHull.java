import java.util.ArrayList;
import java.util.Scanner;

class Point {

    double x;
    double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

}

public class ConvexHull {

    public static void read(Point[] a, int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            a[i] = new Point(sc.nextDouble(), sc.nextDouble());
        }
        sc.close();
    }

    public static void print(Point[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void getConvexHull(Point[] p, int n) {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        // Vector <Integer> x = new Vector<>();
        // Vector <Integer> y = new Vector<>();

        for (int i = 0; i < n - 1; i++) {
            Point p_i = p[i];
            for (int j = i + 1; j < n; j++) {
                Point p_j = p[j];
                double a = p_j.y - p_i.y;
                double b = p_i.x - p_j.x;
                double c = p_j.y * p_i.x - p_i.y * p_j.y;

                boolean flag = true;
                int newSign, oldSign = 2;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    Point p_k = p[k];
                    if (a * p_k.x + b * p_k.y < c)
                        newSign = -1;
                    else if (a * p_k.x + b * p_k.y > c)
                        newSign = 1;
                    else
                        newSign = 0;

                    if (newSign == 0 && p_i.distance(p_j) + p_j.distance(p_k) != p_i.distance(p_j) + 0.000001) {
                        flag = false;
                        break;
                    } else if (oldSign == 2 && newSign != 0) {
                        oldSign = newSign;
                    }
                }
                if (flag) {
                    x.add(p_i.x);
                    x.add(p_j.x);
                    y.add(p_i.y);
                    y.add(p_j.y);

                }

            }

        }
        System.out.println("Egdes of the Convex hull are :");
        for (int i = 0; i < x.size(); i += 2) {
            System.out.println("(" + x.get(i) + "," + y.get(i) + ")->(" + x.get(i + 1) + "," + y.get(i + 1) + ")");

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many points ? ");
        int n = sc.nextInt();
        Point[] a = new Point[n];
        read(a, n);
        System.out.println(" The set of points are :");
        print(a);
        getConvexHull(a, n);
        sc.close();

    }
}
