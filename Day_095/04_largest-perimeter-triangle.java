class Solution {
    public int largestPerimeter(int[] nums) {
        //Sort the array to get the maximum elements in the end
        Arrays.sort(nums);
        int n=nums.length;
		//checking from the strating till i>=2 as we will need 3 side to form a traingle
        for(int i=n-1;i>=2;i--){
			//Now storing the sum of the i-1 and i-2 in sum and comparing with i
            int sum=nums[i-1]+nums[i-2];
			//If we found the max we will just return it
            if(nums[i]<sum){
                return sum+nums[i];
            }
        }
		//Otherwise return 0 for false
        return 0;
    }
}