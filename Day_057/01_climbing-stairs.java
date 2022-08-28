

class Solution {
    public int climbStairs(int n) {
        //int[] dp = new int[n+1];
        //return occu(n, dp);
        int prev = 1;
        int prev2 = 1;
        for(int i=1; i<n; i++) {
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        return prev;
        
        
    }
    private static int occu(int n, int[] dp) {
        if(n<=1) return 1;
        if(dp[n]>0) return dp[n];
        int op1 = occu(n-1, dp);
        int op2 = occu(n-2, dp);
        return dp[n] = op1+op2;
    }
}