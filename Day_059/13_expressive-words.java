class Solution {
    
    public boolean check(String s, String word) {
        int i=0; 
        int j=0;
        
        while(i<s.length() && j <word.length()) {
            if(s.charAt(i)==word.charAt(j)) {
                int ln1 = getlen(s,i);
                int ln2 = getlen(word, j);
            
                if(ln1 == ln2) {
                    i+=ln1;
                    j+=ln2;
                    continue;
                } 
                else if(ln1>=3 && ln1>ln2) {
                }
                else {
                return false;
                }
                i+=ln1;
                j+=ln2;
            }
            else {
                return false;
            }
        }
        return i==s.length() && j==word.length();        
    }
    
    public int getlen(String s, int i) {
        int c=1;
        for(int k=i+1; k<s.length(); k++) {
            if(s.charAt(k) == s.charAt(k-1)) {
                c++;
            }
            else {
                break;
            }
        }
        return c;
    }
    
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for(String word: words) {
            if(check(s,word)){
                ans++;
            }
        }
        return ans;
    }
}