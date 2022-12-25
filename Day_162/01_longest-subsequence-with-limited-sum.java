class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for(int i = 0; i < res.length; i++){
            res[i] = getRes(nums, queries[i]);
        }
        return res;
    }
    private int getRes(int[] nums, int sum){
        int res = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            if(res+nums[i] <= sum){
                res += nums[i];
                count++;
            }
            else return count;
        }
        return count;
    }
}
