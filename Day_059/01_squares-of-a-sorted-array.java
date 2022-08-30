class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0,j=nums.length-1,ind=j;
        int [] ans=new int[j+1];
        while(i<=j){
            int left=nums[i]*nums[i];
            int right=nums[j]*nums[j];
            if(left>right){
                ans[ind--]=left;
                i++;
            }
            else{
                ans[ind--]=right;
                j--;
            }
        }
        return ans;
    }
}