class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0; int ln = nums.length;
        for(int i=0; i<ln; i++) {
            for(int j=i+1; j<ln; j++) {
                if(nums[i]==nums[j]) {
                    count++;
                }
            }
        }
    return count;
    }
}
