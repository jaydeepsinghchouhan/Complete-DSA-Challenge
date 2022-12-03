class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())  return false;    // Not same length strings.
        if (word1.equals(word2))  return true;                  // Both strings identical.

        // Get the count (frequency) of each character in each string.
        int[] freq1 = new int[128];     // Count of each char in word1
        int[] freq2 = new int[128];     // Count of each char in word2
        for (char c : word1.toCharArray())  freq1[c]++;
        for (char c : word2.toCharArray())  freq2[c]++;
        
        // Find highest count for any character.
        int maxFreq = 0;
        for (int i = 'a'; i <= 'z'; i++)
            maxFreq = Math.max(maxFreq, Math.max(freq1[i], freq2[i]));

        // Make sure that each character in one string exists in the other string, even though 
        // the counts of the character in each string is different.  For all the counts of 
        // characters in each string, make sure there is the same count in the other string, 
        // even though the counts may be for different characters.
        byte[] freqFreq = new byte[maxFreq + 1];    // Up/down counters for any frequency 
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            int f1 = freq1[i];
            int f2 = freq2[i];
            if ((f1 == 0) ^ (f2 == 0))  return false;   // If a char in one string, is not in the other string.
            if (f1 != 0) {
                int f1f = freqFreq[f1]++;
                int f2f = freqFreq[f2]--;
                if (f1f == 0)  count++;  else  if (f1f == -1)  count--;
                if (f2f == 0)  count++;  else  if (f2f ==  1)  count--;
            }
        }
        return count == 0;  // Return true only if the counts of characters are the same in 
                            // both strings.
    }
}