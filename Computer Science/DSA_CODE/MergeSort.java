public class MergeSort {

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    // Merge sort function
    public static void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    // Merge function to merge two sorted subarrays
    public static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        // Create temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays left[] and right[]
        for (int i = 0; i < n1; ++i)
            left[i] = array[p + i];
        for (int j = 0; j < n2; ++j)
            right[j] = array[q + 1 + j];

        // Merge the temporary arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = p;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[], if there are any
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[], if there are any
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    // Utility function to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
