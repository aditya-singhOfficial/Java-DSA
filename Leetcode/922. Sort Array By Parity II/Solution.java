class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even=0, odd=1;
        for(int i=0; i<nums.length; i++){
            if((nums[i] % 2 == 0) && (i % 2 == 0)) continue;
            if((nums[i] % 2 != 0) && (i % 2 != 0)) continue;
            if(nums[i] % 2 == 0){
                int temp = nums[i];
                nums[i] = nums[even];
                nums[even] = temp;
                even+=2;
                i--;
            }
            if(nums[i] % 2 != 0){
                int temp = nums[i];
                nums[i] = nums[odd];
                nums[odd] = temp;
                odd+=2;
                i--;
            }
        }
        return nums;
    }
}