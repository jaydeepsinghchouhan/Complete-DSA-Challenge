class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(n < m) return findMedianSortedArrays(nums2, nums1);
        
        int start = 0, end = m;
        int median = (m+n+1)/2;
        
        while(start<=end){
            int cut1 = start+(end-start)/2;
            int cut2 = median - cut1;            
            
            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int R1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int R2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];
            
            if(L1 <= R2 && L2 <= R1){
                if((m+n)%2 == 0)
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
                else
                    return Math.max(L1,L2);
            }
            else if(L2 > R1){
                start = cut1+1;
            }
            else{
                end = cut1-1;
            }
        }
        return 0.0;
    }
}