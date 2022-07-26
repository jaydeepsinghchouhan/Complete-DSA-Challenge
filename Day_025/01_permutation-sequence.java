class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n]; 
        for(int i=1; i<=nums.length; i++) nums[i-1] = i;
        
        // k-1, because we assume 0-indexed permutations
        solve(k-1, n, nums);
        
        StringBuilder s = new StringBuilder();
        
        for (int i=n-1; i>=0; i--) { 
            s.append((char)(nums[i] + '0'));
        }
            
        return s.toString();
    }
    
    private void solve(int k, int n, int[] nums) {
        if (n == 0) return; 
        int f = factorial(n-1); 
        int i = k / f;
        rearrange(i, n, nums);
        solve(k%f, n-1, nums);
    }
    
    private void rearrange(int i, int len, int[] nums) { 
        int temp = nums[i];
        for (int j=i; j<len-1; j++) { 
            nums[j] = nums[j+1]; 
        }
        nums[len-1] = temp;
    }
    
    private int factorial(int x) { 
        if (x == 0) return 1; 
        int ans = 1; 
        while(x > 0) ans *= x--;  
        return ans; 
    }
}