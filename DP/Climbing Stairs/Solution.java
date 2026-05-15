import java.util.Arrays;

class Solution {
    public static int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        Arrays.fill(stairs, -1);
        System.out.println("Using DP memoization: " + climbUsingDPMemo(n, 0, stairs));
        System.out.println("Using DP Tabuliztion: " + climbUsingDPTab(n));
        return climbUsingRecurssion(n, 0); // using recursion

    }

    static int climbUsingDPTab(int n) {
        if (n == 1)
            return 1;
        int[] stairs = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;
        for (int i = 2; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }

    static int climbUsingDPMemo(int n, int stair, int[] stairs) {
        if (n == stair)
            return 1;
        if (n < stair)
            return 0;
        if (stairs[stair] != -1) {
            return stairs[stair];
        }

        stairs[stair] = climbUsingDPMemo(n, stair + 1, stairs) +
                climbUsingDPMemo(n, stair + 2, stairs);

        return stairs[stair];
    }

    static int climbUsingRecurssion(int n, int stair) {
        if (stair == n)
            return 1;
        if (stair > n)
            return 0;

        return climbUsingRecurssion(n, stair + 1) + climbUsingRecurssion(n, stair + 2);
    }

    public static void main(String[] args) {
        System.out.println("Using Recurssion: " + climbStairs(5));
    }
}