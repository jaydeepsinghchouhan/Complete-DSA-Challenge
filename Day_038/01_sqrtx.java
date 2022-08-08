class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return x;
        }
        long st = 1;
        long end = x;
        
        while(st<=end) {
            long mid = st+(end-st)/2;
            long sq = mid*mid;
            if(sq == x) {
                return (int)mid;
            }
            else if(sq<x) {
                st = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        if(end*end == x) {
            return (int)end-1;
        }
        else {
            return (int)st-1;
        }
    }
}