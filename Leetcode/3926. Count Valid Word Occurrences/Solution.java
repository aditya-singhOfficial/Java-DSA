import java.util.*;
import java.util.regex.*;

class Solution {

    public int[] countWordOccurrences(String[] chunks, String[] queries) {

        StringBuilder sb = new StringBuilder();

        for (String s : chunks) {
            sb.append(s);
        }

        String str = sb.toString();

        HashMap<String, Integer> map = new HashMap<>();

        Pattern p = Pattern.compile("[a-z]+(?:-[a-z]+)*");

        Matcher m = p.matcher(str);
        System.out.println(m);
        while (m.find()) {

            String word = m.group();
            System.out.println("Word: " + word);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] chunks = { "a--b a-","-c" };
        String[] queries = { "a", "b", "c" };
        new Solution().countWordOccurrences(chunks, queries);
    }
}