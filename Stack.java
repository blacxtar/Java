
public class Stack<T> {
    T arr[];
    int tos;
    int length;

    @SuppressWarnings("unchecked")
    Stack(int n) {
        this.arr = (T[]) new Object[n];
        this.tos = -1;
        this.length = n;
        System.out.println("Stack created with capacity :" + this.length);
    };

    boolean isEmpty() {
        if (tos == -1) {
            return true;
        } else {
            return false;
        }
    }

    int size() {
        return tos + 1;
    }

    void push(T val) {
        if (tos == length - 1) {
            throw new RuntimeException("stack is full");
        } else {
            arr[tos + 1] = val;
            tos++;
        }
    }

    T pop() {
        if (tos == -1) {
            throw new RuntimeException("stack is empty");
        } else {
            T del = arr[tos];
            tos--;
            return del;
        }
    }

    T peep(int idx) {
        if (idx < 0 || idx > tos) {
            throw new RuntimeException("ÏNvalid index");
        } else {
            return arr[tos - idx];

        }
    }

    void display() {
        for (int i = 0; i < size(); i++) {
            System.out.println(arr[i]);
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>(5);
        Stack<String> s2 = new Stack<String>(5);
        s2.push("Stack 0");
        s2.push("Stack 1");
        s2.push("Stack 2");
        s2.push("Stack 3");
        s1.push(4);
        s1.push(3);
        s1.push(2);
        s1.push(1);
        s1.display();
        System.out.println("_____________________");

        // s2.pop();
        s2.display();
        // System.out.println(s2.peep(2));
        // System.out.println("size of stack" + s2.size());

    }

}