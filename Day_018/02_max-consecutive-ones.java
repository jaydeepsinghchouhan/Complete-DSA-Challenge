class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ans = 0;
        for(int item : nums) {
            if(item == 1){
                count++;
            }
            
            if(item != 1) {
                if(ans<count) {
                    ans = count;
                }
                count = 0;
            }
            
        }
        if(ans<count) {
            ans = count;
        }
        
        return ans;
    }
}