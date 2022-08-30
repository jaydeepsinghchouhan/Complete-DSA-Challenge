class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int first=0;
        int second=0;

        while(second<n)
        {
            if(nums[second]!=0)
            {
                int temp=nums[first];
                nums[first]=nums[second];
                nums[second]=temp;
                first++;
            }
            second++;
        }
    }
}