class Solution {
  public int minDifficulty(int[] job, int d) {
      int n = job.length;
      if(d>job.length) return -1;
      int[][] dp = new int[d+1][n];
      for(int[] p: dp) Arrays.fill(p,-1);
      return dfs(job, d, dp, 0);
  }
  private int dfs(int[] job, int d, int[][] dp, int idx){
      if(d==1){
          int max = 0;
          while(idx<job.length) max = Math.max(max, job[idx++]);
          return max;
      }
      if(dp[d][idx]!=-1) return dp[d][idx];
      int max = 0; int res = Integer.MAX_VALUE;
      for(int i = idx; i<job.length-d+1; i++){
          max = Math.max(max, job[i]);
          res = Math.min(res, max + dfs(job, d-1, dp, i+1));
      }
      return dp[d][idx] = res;
  }  
}