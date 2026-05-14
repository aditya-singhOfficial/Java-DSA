import java.util.ArrayList;

public class PermutationOfString {

    static ArrayList<String> allPermutation(char[] s, int pos, ArrayList<String> result) {
        if (pos == s.length - 1) {
            result.add(new String(s));
            return result;
        }

        for (int i = pos; i < s.length; i++) {
            swap(s, pos, i);
            allPermutation(s, pos + 1, result);
            swap(s, pos, i);
        }
        return result;
    }

    static void swap(char[] s, int si, int ei) {
        char temp = s[si];
        s[si] = s[ei];
        s[ei] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> result = allPermutation(s.toCharArray(), 0, new ArrayList<>());
        System.out.println(result);
    }
}