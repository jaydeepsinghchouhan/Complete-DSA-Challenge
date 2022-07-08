class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);      
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void reverse(int[] A, int i, int j){
        while(i<j) swap(A, i++, j--);
    }
}