package PriorityQueue;

public class HeapSort2 {

    static void heapSort(int[] arr) {
        int n = arr.length;
        // Build Min-Heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Sort by swapping last index and first index and then do hepify
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    static void heapify(int[] arr, int pos, int size) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        int minIdx = pos;

        if (left < size && arr[left] < arr[minIdx]) {
            minIdx = left;
        }
        if (right < size && arr[right] < arr[minIdx]) {
            minIdx = right;
        }

        if (minIdx != pos) {
            swap(arr, pos, minIdx);
            heapify(arr, minIdx, size);
        }
    }

    static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 4, 3, 2, 8 };
        heapSort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
