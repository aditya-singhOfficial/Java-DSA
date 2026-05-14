import java.util.ArrayList;
import java.util.Collections;

public class SubSetOfArray {
    static void subSet(
            int[] arr,
            int pos,
            ArrayList<Integer> subset,
            ArrayList<ArrayList<Integer>> result) {
        if (pos == arr.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(arr[pos]);
        subSet(arr, pos + 1, subset, result);
        subset.remove(subset.size() - 1);
        subSet(arr, pos + 1, subset, result);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        subSet(arr, 0, new ArrayList<>(), result);
        Collections.sort(result, (a, b) -> a.size() - b.size());
        System.out.println(result);
    }
}
