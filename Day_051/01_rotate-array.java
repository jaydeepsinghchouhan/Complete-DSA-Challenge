class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%nums.length;
        
        rotate(nums,0,n-k-1);
        rotate(nums,n-k,n-1);
        rotate(nums,0,n-1);
    }
    public void rotate(int[] nums, int pos, int n){
        
       while(pos <= n){
           int temp = nums[pos];
           nums[pos] = nums[n];
           nums[n] = temp;
           pos++;
           n--;
       }
        
    }
}