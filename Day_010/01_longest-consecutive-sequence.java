class Solution {
    public int longestConsecutive(int[] nums) {
      Set <Integer> set = new HashSet <Integer>();
      for(int n : nums)
        set.add(n);
      
      int streak = 0;
      for(int n : nums) {
        if(!set.contains(n - 1)) {
          int currNum = n;
          int currStreak = 1;
          
          while(set.contains(currNum + 1)) {
            currNum ++;
            currStreak ++;
          }
		  
          streak = Math.max(streak , currStreak);
      }
    }
      return streak;
  }
}