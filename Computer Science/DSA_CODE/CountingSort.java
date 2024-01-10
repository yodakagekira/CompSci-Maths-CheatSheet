public class CountingSort {

    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];

        // Initialize counting array
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        // Count occurrences of each element in A
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        // Calculate cumulative counts
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // Build the sorted array
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 0, 2, 1, 1, 0, 3};
        int k = 4; // The range of input values
        int[] B = new int[A.length];

        countingSort(A, B, k);

        // Print the sorted array
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }
}
