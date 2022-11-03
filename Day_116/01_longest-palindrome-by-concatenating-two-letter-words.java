class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word : words) {
            // Get the flipped word.
            String flipped = "" + word.charAt(1) + word.charAt(0);

            // If the flipped word is found, reduce the count of the flipped word.
            // Removing the key from the map when it is 0 is important later on when we need to check for the center word
            // that can form the palindrome.
            if (map.containsKey(flipped)) {
                max += 4;
                map.put(flipped, map.get(flipped) - 1);
                if (map.get(flipped) == 0) map.remove(flipped);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        // For the odd word in the center of the palindrome (e.g. "aa", "bb", "cc", etc.),
        // Check for all 26 possible pairs, if any is found, increase the max by 2.
        // For Example: words = ["ab","ba","zz","yy"]
        //              With "ab" and "ba" form a pair, with max = 4,
        //              either "zz" or "yy" can fit in the center to expand the palindrome, forming "abzzba" or "abyyba".
        // Exit the for-loop once found, as we only can use one at the center.
        for (int i = 0; i < 26; i++) {
            char current = (char) ('a' + i);
            if (map.getOrDefault("" + current + current, 0) > 0) {
                max += 2;
                break;
            }
        }
        return max;
    }
}
 