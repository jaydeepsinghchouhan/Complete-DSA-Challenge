class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int x = 0;
        for(int item: nums) {
            if(count==0) {
                x = item;
            }
            if(item == x) {
                count++;
            }
            else {
                count--;
            }
        }
        return x;
    }
}