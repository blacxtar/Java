public class Permutations {
   
        public static void generatePermutations(int[] array) {
            generatePermutations(array, 0, array.length - 1);
        }
    
        private static void generatePermutations(int[] array, int left, int right) {
            if (left == right) {
                printArray(array);
            } else {
                for (int i = left; i <= right; i++) {
                    swap(array, left, i);
                    generatePermutations(array, left + 1, right);
                    swap(array, left, i); // backtrack
                }
            }
        }
    
        private static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    
        private static void printArray(int[] array) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5};
            generatePermutations(array);
        }
    }

