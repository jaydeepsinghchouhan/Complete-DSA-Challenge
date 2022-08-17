class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        // base cases
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        
        // initialize search space
        int answer = -1;
        int start = 2;
        int end = n - 3;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // check for non repeating element
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                answer = nums[mid];
                break;
            }
            // bring the mid to first occurrence
            if(nums[mid] == nums[mid-1]) {
                mid--;
            }            
            if(mid % 2 == 0) {
                // if first occurence is at even index, search on right
                start = mid + 2;
            } else {
                // if first occurrence is at odd index, seach on left
                end = mid - 1;
            }
        }
        return answer;
    }
}