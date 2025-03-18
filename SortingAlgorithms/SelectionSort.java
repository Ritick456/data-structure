package SortingAlgorithms;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 6};

        for (int i = 0; i < arr.length - 1; i++) {  // Runs for n-1 times
            int mini = i;  // Index of minimum element

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[mini] > arr[j]) {
                    mini = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
