class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=max){
                nums[index] = nums[i];
                max = nums[i];
                index++;
            }
        }
        return index;
    }
}