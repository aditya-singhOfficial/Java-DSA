import java.util.Arrays;

public class Solution1 {
    static int climbStairs(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    static int climbUsingDPMemo(int n, int[] climbs) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (climbs[n] != -1)
            return climbs[n];
        climbs[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return climbs[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] climbs = new int[n + 1];
        Arrays.fill(climbs, -1);
        System.out.println("Using Recurssion: " + climbStairs(n));
        System.out.println("Using DP Memoization: " + climbUsingDPMemo(n, climbs));
    }
}
