import java.util.Arrays;

public class QuickSort {

    // The main function that implements QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the partitioning index
            int partitionIndex = partition(arr, low, high);

            // Recursively sort elements before and after the partition index
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Helper method to partition the array into two halves
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the rightmost element as the pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7, 3, 1, 15};
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
