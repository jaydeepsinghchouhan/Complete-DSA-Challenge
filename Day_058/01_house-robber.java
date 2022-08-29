class Solution {
    
//     private static int f(int[] nums, int n, int[] dp) {
//         if(n==0) return nums[0];
//         if(n<0) return 0;
//         if(dp[n]>0) return dp[n];
//         int pick = nums[n] + f(nums, n-2, dp);
//         int notpick = f(nums, n-1, dp);
//         return dp[n] = Math.max(pick, notpick);
//     }
    
    public int rob(int[] nums) {
        int n = nums.length;
//         int[] dp = new int[n];
//         // return f(nums, n-1, dp);
        
//         dp[0] = nums[0];
//         for(int i=1; i<n; i++) {
//             int pick = nums[i];
//             if(i>1) pick+= dp[i-2];
//             int notpick = dp[i-1];
//             dp[i] = Math.max(pick, notpick);
//         }
//         return dp[n-1];
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
}