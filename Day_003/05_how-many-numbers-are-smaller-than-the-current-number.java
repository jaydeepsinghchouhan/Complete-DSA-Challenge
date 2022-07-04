class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int temp[] =new int[102];
        for(int i=0;i<nums.length;i++){
           temp[nums[i]]+=1;
        }
        for(int i=1;i<101;i++){
           temp[i]=temp[i]+temp[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                
            }
            else
           nums[i]=temp[nums[i]-1];
        }
        return nums;

    }
}