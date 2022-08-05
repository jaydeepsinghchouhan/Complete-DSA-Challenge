class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        
        if(nums.length<4){
            return res;
        }
        
        for(int i=0;i<=nums.length-4;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int val=nums[i];
            List<List<Integer>> subList=threeSum(nums,i+1,target-val);
            
            for(List<Integer> ls:subList){
                ls.add(val);
                res.add(ls);
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> threeSum(int []nums, int si, int target){
        List<List<Integer>> res=new ArrayList<>();
        
        for(int i=si;i<=nums.length-3;i++){
            if(i!=si && nums[i]==nums[i-1]){
                continue;
            }
            
            long val=(long)target-(long)nums[i];
            int s=i+1;
            int e=nums.length-1;
            
            while(s<e){
                if(s!=i+1 && nums[s]==nums[s-1]){
                    s++;
                    continue;
                }
                
                if(e!=nums.length-1 && nums[e]==nums[e+1]){
                    e--;
                    continue;
                }
                
                if(((long)nums[s]+(long)nums[e])==(long)val){
                    List<Integer> subList=new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[s]);
                    subList.add(nums[e]);
                    
                    res.add(subList);
                    s++;
                    e--;
                }else if(((long)nums[s]+(long)nums[e])<(long)val){
                    s++;
                }else{
                    e--;
                }
            }
        }
        
        return res;
    }
}