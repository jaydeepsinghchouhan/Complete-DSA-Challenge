class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] ans = new int[26];
        
        for(int i = 0; i < sentence.length(); i++)
            ans[sentence.charAt(i) - 97] +=1;
        
        for(int i = 0; i < 26; ++i)
        {
            if(ans[i] == 0)
                return false;
        }
        
        return true;
    }
}