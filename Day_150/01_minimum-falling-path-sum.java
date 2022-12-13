class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] A) {
        dp = new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
           for(int j=0;j<A[i].length;j++){
                getMinimum(A,i,j); 
           } 
        }
        int res = Integer.MAX_VALUE;
        for(int a:dp[dp.length-1]){
            if(a<res)res =a;
        }
        return res;
    }
    
    private void getMinimum(int[][] A,int i, int j){
        dp[i][j] = A[i][j];
        if(i==0)return;
        if(i>0 && j==0){
            dp[i][j] += Math.min(dp[i-1][j],dp[i-1][j+1]);
        }else if(i>0 && j==A[i].length-1){
            dp[i][j] += Math.min(dp[i-1][j],dp[i-1][j-1]);
        }else{
            dp[i][j] += Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
        }
    }
}