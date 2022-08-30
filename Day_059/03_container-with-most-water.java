class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int maxWater = -1;
        while(left<right) {
            int mini = Integer.MAX_VALUE;
            if(height[left]>=height[right]) {
                int temp = (right-left)*height[right];
                maxWater = Math.max(maxWater, temp);
                right--;
            }
            else {
                int temp = (right-left)*height[left];
                maxWater = Math.max(maxWater, temp);
                left++;
            }
            
        }
        return maxWater;
    }
}