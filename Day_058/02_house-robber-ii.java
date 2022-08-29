class Solution {
    public int robb(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<n; i++) {
            int pick = nums[i] + prev2;
            int notpick = prev;
            int curri = Math.max(pick, notpick);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] ans1 = new int[n-1];
        int[] ans2 = new int[n-1];
        if(n==1) {
            return nums[0];
        }
        for(int i=0; i<n; i++) {
            if(i != 0) {
                ans1[i-1] = nums[i];
            }
            if(i != n-1) {
                ans2[i] = nums[i];
            }
        }
        return Math.max(robb(ans1), robb(ans2));
    }
    
}