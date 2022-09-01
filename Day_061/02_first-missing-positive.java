class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length) { 
                i++;
            } else {

                int correct = nums[i] - 1; 

                if (nums[i] != nums[correct]) {
                    swap(nums, i, correct); 
                } else {
                    i++;
                }
            }

        }

        
        int index = 0;
        while(index < nums.length){
            if(nums[index] != index + 1){
                return index + 1;
            }
            else{
                index++;
            }
        }
        return nums[index - 1] + 1;
    }

   
    void swap(int[] nums, int i, int correct) {
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
}