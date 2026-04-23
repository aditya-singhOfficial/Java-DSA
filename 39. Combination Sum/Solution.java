class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    void get(int[] nums, int sum, List<Integer> l1, int i, int target){
        int j;
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<Integer>(l1));
            return;
        }
        for(j=i; j<nums.length; j++){
            l1.add(nums[j]);
            get(nums, sum+nums[j],l1,j,target);
            l1.remove(l1.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l1 = new ArrayList<>();
        get(candidates,0,l1,0,target);
        return res;
    }
}