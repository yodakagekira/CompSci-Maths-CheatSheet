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
        int pivotIndex = choosePivot(arr, low, high); // This can be adjusted as needed
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high); // Move the pivot to end for the algorithm
        
        int i = low; // Index for the smaller element

        // Partitioning the array
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivotValue) {
                swap(arr, i, j);
                i++;
            }
        }

        // Swap the pivot back to its correct place
        swap(arr, i, high);

        return i; // Returning the pivot index after partition
    }

    // Swap utility
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method for choosing the pivot
    private static int choosePivot(int[] arr, int low, int high) {
        // This can be any logic: first element, last element, random element, median, etc.
        // For simplicity, we'll choose the middle element here.
        return low + (high - low) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7, 3, 1, 15};
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
