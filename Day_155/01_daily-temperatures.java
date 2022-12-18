class Solution {
        public int[] dailyTemperatures(int[] T) {
        int[]dp=new int[T.length];
        dp[dp.length-1]=0;
        for(int i=dp.length-2;i>=0;--i){
            if(T[i+1]>T[i]){
                dp[i]=1;
            }else{
                int j=i+1;
                while(j<dp.length&&dp[j]>0){
                    if(T[j+dp[j]]>T[i]){
                        dp[i]=j+dp[j]-i;
                        break;
                    }
                    j+=dp[j];
                }
            }
        }
        return dp;
    }
}