class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int target[] = new int[index.length];
        for(int i=0; i<index.length; i++) {
            target[i]= -1;
        }
        
        int i=0;
        for(i=0; i<index.length; i++) {
            if(target[index[i]]==-1)
            {
                target[index[i]] = nums[i];    
            }
            else {
                int j=0;
                for(j=index[i]; j<nums.length; j++) {
                    if(target[j]==-1) {
                        break;
                    }
                }
                while(index[i]<j) {
                    target[j] = target[j-1];
                    j--;
                }
                target[index[i]] = nums[i]; 
            }
            
        }
        return target;
    }
}