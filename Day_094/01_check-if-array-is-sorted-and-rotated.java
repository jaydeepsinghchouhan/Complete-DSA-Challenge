class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        if(n==1)return true;
        int count = 0;
        for(int i=0; i<n; i++) {    //i<n-1
            if(nums[i]>nums[(i+1)%n]) count++;
        }
        //if(nums[n-1]>nums[0])   count++;
        if(count>1) return false;
        return true; 
    }
}