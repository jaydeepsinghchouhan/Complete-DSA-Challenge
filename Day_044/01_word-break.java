class Solution {
    boolean check=false;
    
    HashMap<String, Boolean> dp = new HashMap<>();
    
    boolean solve(String s, List<String> wordDict){
        if(s.length()==0) return true;
        if(dp.containsKey(s)) return dp.get(s);
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                check = check || solve(s.substring(word.length()), wordDict);
            }
        }
        dp.put(s, check);
        return dp.get(s);
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
}