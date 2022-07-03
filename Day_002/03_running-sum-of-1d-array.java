class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        int ans[] = new int[length];
        int temp = 0;
        for(int i=0; i<length; i++) {
            temp+=nums[i];
            ans[i] = temp;
        }
        return ans;
    }
}