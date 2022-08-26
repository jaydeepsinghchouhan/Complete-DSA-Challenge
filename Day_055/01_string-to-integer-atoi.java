// leading zero
// operator '+' and '-'

// Integer range 
    // -2xxxx648  -  +2xxxx647

class Solution {
    public int myAtoi(String s) {
        
        int index= 0;
        boolean isNegative = false;
        int res = 0;
        
        while(index < s.length() && (s.charAt(index) == ' '))
            index++;

        if(index == s.length())
            return res;

        if(s.charAt(index) == '-'){
            isNegative = true;
            index++;
        }else if (s.charAt(index) == '+'){
            isNegative = false;
            index++;
        }

        while(index < s.length() && Character.isDigit(s.charAt(index))){
            int pop = s.charAt(index)-'0';
            if(isNegative){
                if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && pop > 8){
                    return Integer.MIN_VALUE;
                }
            }else {
                if (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && pop > 7)
                    return Integer.MAX_VALUE;
            }
            res = res * 10 + pop;
            index++;
        }   

        
        if(isNegative){
            return -res;
        }
        
        return res;
    }
}