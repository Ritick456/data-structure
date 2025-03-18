package SortingAlgorithms;

public class QuickSort {

    // Swap function to swap two elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end) {
        int idx = start - 1;  // Fix index initialization
        int pivot = arr[end];

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                idx++;
                swap(arr, j, idx);  // Fix swap call
            }
        }

        idx++;
        swap(arr, idx, end); // Swap pivot with correct position
        return idx;
    }

    public static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quicksort(arr, start, pivot - 1);
            quicksort(arr, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 12, 5, 2};

        quicksort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
