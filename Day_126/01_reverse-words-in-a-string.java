class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0) {
            while(i>=0 && s.charAt(i) == ' ') {
                i--;
            }

            if(i < 0) {
                break;
            }

            int j = i;
            while(j>=0 && s.charAt(j) != ' ') {
                j--;
            }

            for(int k=j+1 ; k<=i ; k++) {
                sb.append(s.charAt(k));
            }

            sb.append(" ");
            i=j;
        }

        if(sb.charAt(sb.length()-1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}