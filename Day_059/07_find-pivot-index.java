class Solution {
    public int pivotIndex(int[] nums) {
        int sum =0;
        for(int i:nums) {
            sum+=i;
        }
        int ls = 0;
        int rs = sum;
        
        for(int i=0; i<nums.length; i++) {
            rs -=nums[i];
            if(rs==ls)return i;
            ls+=nums[i];
        }
        return -1;
    }
}