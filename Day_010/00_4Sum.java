class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length == 0) return res;
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                long target2;
                target2 = (target - nums[i] - nums[j] );
                if(target2<-2147483648) {
                    return res;
                }
                
                
                int front = j+1;
                int back = n-1;
                
                while(front<back) {
                    int twoSum = nums[front]+nums[back];
                    if(twoSum<target2) front++;
                    else if(twoSum>target2) back--;
                    else if(twoSum == target2){
                        List<Integer> quads = new ArrayList();
                        quads.add(nums[i]);
                        quads.add(nums[j]);
                        quads.add(nums[front]);
                        quads.add(nums[back]);
                        res.add(quads);
                        
                        while(front<back && nums[front] == quads.get(2)) front++;
                        while(front<back && nums[back] == quads.get(3)) back--;
                    }
                }
                
                while(j+1<n && nums[j+1] == nums[j]) j++;
                while(i+1<n && nums[i+1] == nums[i]) i++;
                
            }
            
        }
        return res;
    }
}