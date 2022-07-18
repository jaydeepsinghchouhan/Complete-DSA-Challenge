class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        for(int i=0; i<n-2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int st = i+1, end = n-1;
                while(st < end) {
                    if(nums[i]+nums[st]+nums[end]==0) {
                    
                        res.add(Arrays.asList(nums[i],nums[st],nums[end]));
                    
                        while(st < end && nums[st]==nums[st+1]) st++;
                        while(st < end && nums[end]==nums[end-1]) end--;
                    
                        st = st+1;
                        end = end -1;
                    }
                    else if(nums[i]+nums[st]+nums[end] > 0) end--;
                    else st++;
                    
                }
            }
        }
        return res;
    } 
}
