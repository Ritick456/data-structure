package SortingAlgorithms;


import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return; // Handle empty array case

        // Step 1: Find the maximum element in the array
        int max = Arrays.stream(arr).max().getAsInt();

        // Step 2: Create a frequency/count array
        int[] count = new int[max + 1];

        // Step 3: Count occurrences of each element
        for (int num : arr) {
            count[num]++;
        }

        // Step 4: Modify count array to store the cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build the sorted array
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--; // Decrease count
        }

        // Step 6: Copy sorted elements back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original array: " + Arrays.toString(arr));

        countingSort(arr);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}
