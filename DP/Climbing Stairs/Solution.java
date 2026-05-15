import java.util.Arrays;

class Solution {
    public static int climbStairs(int n) {
        return climbUsingRecurssion(n, 0); // using recursion

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