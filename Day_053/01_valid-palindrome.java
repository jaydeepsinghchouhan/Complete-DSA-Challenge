class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char l = s.charAt(i), r = s.charAt(j);

            if (!Character.isLetterOrDigit(l)) {
                i++;
            } else if (!Character.isLetterOrDigit(r)) {
                j--;
            } else if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}