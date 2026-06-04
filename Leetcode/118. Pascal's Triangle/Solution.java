import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> pas1 = new ArrayList<>();
            for (int j = 2; j <= i; j++) {
                int add = pascal.get(i - 1).get(j - 2) + pascal.get(i - 1).get(j - 1);
                pas1.add(add);
            }
            pas1.addFirst(1);
            if (i >= 1)
                pas1.addLast(1);
            pascal.add(pas1);
        }
        return pascal;
    }

    public static void main(String[] args) {

        List<List<Integer>> pascal = generate(5);
        System.out.println(pascal);
    }
}