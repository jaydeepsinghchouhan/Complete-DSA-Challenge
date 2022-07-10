class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long tempN = n;
        if(tempN<0){
            tempN*=-1;
        }
        while(tempN>0) {
            if(tempN%2==0) {
                x*=x;
                tempN/=2;
            }
            else {
                tempN-=1;
                ans = ans*x;
            }
        }
        if(n<0) {
            ans = (double)(1.0)/(double)(ans);
        }
        return ans;
    }
}