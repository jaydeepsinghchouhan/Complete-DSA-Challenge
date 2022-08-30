/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long  low = 1;
        long  high = n;
        while(high >= low){
            long  mid = (low+high)/2;
            if(!isBadVersion((int)mid))
                low = mid+1;
            else{
                high = mid-1;
            }
        }
        return (int)low;
    }
}