class Solution {
    public int maximumDifference(int[] nums) {
        int i=0, j=1;
        int maxDiff = -1;
        int n = nums.length;
        while(j<n) {
            if(nums[i]<nums[j]) {
                int diff = nums[j]-nums[i];
                if(diff>maxDiff) {
                    maxDiff = diff;
                }
                j++;
            }
            else {
                j++;
                i = j-1;
            }
        }
        return maxDiff;
    }
}