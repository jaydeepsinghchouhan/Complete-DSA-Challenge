class Solution {
    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int ans[] = new int[length];
        for(int i=0; i<length; i++) {
            int temp = nums[i];
            ans[i] = nums[temp];
        }
        return ans;
    }
}