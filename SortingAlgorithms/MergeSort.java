package SortingAlgorithms;

public class MergeSort {

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];

        // Merge two halves into temp array
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back to the original array
        for (i = start, k = 0; i <= end; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void mergesort(int[] arr, int start, int end) {
        if (start >= end) {  // Base condition
            return;
        }

        int mid = start + (end - start) / 2;

        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 6};

        mergesort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
