class Solution {
    public String makeGood(String s) {
    	char[] chr = s.toCharArray();
    	int l = 0;
    	for (int r = 0; r < chr.length; r++)
    		if (l > 0 && chr[l - 1] != chr[r] && Character.toLowerCase(chr[l - 1]) == Character.toLowerCase(chr[r]))
				l--;
    		else
				chr[l++] = chr[r];
    	return String.copyValueOf(chr, 0, l);
    }
}