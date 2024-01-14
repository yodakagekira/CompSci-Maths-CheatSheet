import java.util.Arrays;

public class QuickSort {

    // The main function that implements QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 'partitioning' index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition
            quickSort(arr, low, pi - 1);
            // Recursively sort elements after partition
            quickSort(arr, pi + 1, high);
        }
    }

    // This function takes the first element as pivot, places the pivot element at
    // its correct position in sorted array, and places all smaller (smaller than
    // pivot) to left of pivot and all greater elements to right of pivot
    public static int partition(int[] arr, int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = arr[low];

        int i = low; // Index of smaller element and indicates the right position of pivot found so far

        for (int j = low + 1; j <= high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at index i
        swap(arr, i, low);
        return i; // Return the pivot index
    }

    // Utility method to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length -1);
    }
}
    
