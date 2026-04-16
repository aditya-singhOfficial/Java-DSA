class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0];
        int delete = 0;
        int res = arr[0];
        for(int i=1; i<arr.length; i++){
            delete = Math.max(delete+arr[i],keep);
            keep = Math.max(arr[i],keep+arr[i]);
            res = Math.max(res, Math.max(delete,keep));
        }
        return res;
    }
}