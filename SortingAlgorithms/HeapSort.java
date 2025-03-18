package SortingAlgorithms;


public class HeapSort {
    
    // Function to perform heap sort
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root with last element
            swap(arr, 0, i);

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index i
    private void heapify(int arr[], int n, int i) {
        int largest = i;  // Assume root is largest
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // Utility function to swap elements in array
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print the array
    private void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function to test the heap sort implementation
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort hs = new HeapSort();
        System.out.println("Original array:");
        hs.printArray(arr);

        hs.heapSort(arr);

        System.out.println("Sorted array:");
        hs.printArray(arr);
    }
}

