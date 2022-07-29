class Solution {
public int kthGrammar(int n, int k) {

    //Base condition hits so it will return 0
    if(n == 1)
    {
        return 0;
    }

    //Length increases exponentially by power 2 so see the notes for better understanding
    double len = Math.pow(2,n-1);

    if(k <= len/2)
    {
        return kthGrammar(n-1,k);
    }
    else
    {
        return 1- kthGrammar(n-1, k - (int)(len/2)); // Dont use negate it gives negative so use 1 - of number
    }
    
}
}