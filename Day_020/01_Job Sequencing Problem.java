import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
        Arrays.sort(jobs , (a,b) -> Double.compare(a[1],b[1]));
        int MaxTime = 0;
        for(int[] e : jobs){
            MaxTime = Math.max(MaxTime,e[0]);
        }
        int[] time = new int[MaxTime+1];
        int maxProfit = 0;
        for(int i = jobs.length - 1; i >= 0; i--){
            if(time[jobs[i][0] - 1] == 0){
                maxProfit += jobs[i][1];
                time[jobs[i][0]-1] += 1;
            }else{
                // Always start checking from behind
                for(int j = jobs[i][0]-1; j >= 0 ; j--){
                    if(time[j] == 0){
                        maxProfit += jobs[i][1];
                        time[j] += 1;
                        break;
                    }
                }
            }
        }
        return maxProfit;
    }
}