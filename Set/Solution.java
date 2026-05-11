import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();

        s.add(2);
        s.add(4);
        s.add(4);
        s.add(5);
        s.add(28);

        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}