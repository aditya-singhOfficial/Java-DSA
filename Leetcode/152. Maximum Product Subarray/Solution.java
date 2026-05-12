class Solution {
    public int maxProduct(int[] nums) {
        int maxMul = nums[0];
        int minMul = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int prevMax = maxMul;
            int prevMin = minMul;
            maxMul = Math.max(num, Math.max(num * prevMax, num * prevMin));
            minMul = Math.min(num, Math.min(num * prevMax, num * prevMin));
            res = Math.max(res, maxMul);
        }
        return res;
    }
}