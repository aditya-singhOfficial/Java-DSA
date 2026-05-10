package PriorityQueue;

public class HeapSort {

    static void heapSort(int[] arr) {
        int n = arr.length;
        // Build Max-Heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // sort
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    static void heapify(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            swap(arr, maxIdx, i);
            heapify(arr, maxIdx, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 4, 3, 2 };
        heapSort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
