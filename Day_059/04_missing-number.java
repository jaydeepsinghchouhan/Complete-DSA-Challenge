class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i:nums) {
            ans = ans + i;
        }
        int n = nums.length;
        n = n*(n+1)/2;
        ans = n-ans;
        return ans;
    }
}