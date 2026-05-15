public class Fibbonaci {
    static int fib(int n, int[] f) {
        if (n == 0 || n == 1)
            return n;
        if (f[n] != 0)
            return f[n];
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    static int fibTabulation(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] f = new int[n + 1];
        System.out.println(fib(n, f));
        System.out.println(fibTabulation(n));
    }
}