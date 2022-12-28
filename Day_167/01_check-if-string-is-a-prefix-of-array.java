class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int count = 0; 
        char[] chars = s.toCharArray(); 
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (count == chars.length) {
                    return false; 
                }
                if (chars[count++] != c) {
                    return false; 
                }
            }
            if (count == chars.length) {
                return true; 
            }
        }
        return count == chars.length; 
    }
}