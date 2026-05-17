import java.util.ArrayList;

class SolutionUsingRecursion {

    static ArrayList<Integer> bestKnap = new ArrayList<>();
    static int maxVal = Integer.MIN_VALUE;

    static void addInKnapSack(
            int[] val, int[] wt,
            int pos, int W,
            int currWt, int currVal,
            ArrayList<Integer> currentKnap) {

        if (currWt > W)
            return;

        if (currVal > maxVal) {
            maxVal = currVal;
            bestKnap = new ArrayList<>(currentKnap);
        }

        if (pos == val.length)
            return;

        currentKnap.add(val[pos]);

        addInKnapSack(
                val,
                wt,
                pos + 1,
                W,
                currWt + wt[pos],
                currVal + val[pos],
                currentKnap);

        currentKnap.remove(currentKnap.size() - 1);

        addInKnapSack(
                val,
                wt,
                pos + 1,
                W,
                currWt,
                currVal,
                currentKnap);
    }

    static int knapSack(int[] val, int[] wt, int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1);
            int ans2 = knapSack(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapSack(val, wt, W, n - 1);
        }
    }

    public static void main(String[] args) {

        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };

        int W = 7;

        ArrayList<Integer> currKnapSack = new ArrayList<>();

        addInKnapSack(
                val,
                wt,
                0,
                W,
                0,
                0,
                currKnapSack);

        System.out.println(bestKnap);
        System.out.println("Maximum Value = " + maxVal);
        System.out.println("Maximum Value = " + knapSack(val, wt, W, wt.length));
    }
}