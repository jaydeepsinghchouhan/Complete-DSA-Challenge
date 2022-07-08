class Solution {
    public void sortColors(int[] nums) {

        int [] range = new int [3];
        int count = 0;
    
        for (int i : nums){
            range[i]++;
            count++;
        }
    
        int [] ans = new int [count];
        int j = 0;
        int k = 0;
    
        while (count > 0){
            if (range[k] != 0){
                nums[j++] = k;
                range[k]--;
            } else {
                k++;
                count++;
            }
            count--;
        }
    
    
    }
}