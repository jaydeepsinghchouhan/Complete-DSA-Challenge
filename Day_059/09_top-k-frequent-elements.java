class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1]; 
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        for(int key:hm.keySet()) {
            int freq = hm.get(key);
            if(bucket[freq]==null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        int[]ans = new int[k];
        int count =0;
        for(int i=nums.length; i>=0; i--) {
            if(bucket[i]!=null) {
                for(int j=0; j<bucket[i].size(); j++) {
                    ans[count++] = bucket[i].get(j);
                    if(count==k)break;
                }
            }
            if(count==k)break;
        }
        return ans;
    }
}