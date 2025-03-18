package SortingAlgorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 6};

        for (int i = 0; i < arr.length - 1; i++) {  // Outer loop for passes
            for (int j = 0; j < arr.length - 1 - i; j++) {  // Inner loop for swapping
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
