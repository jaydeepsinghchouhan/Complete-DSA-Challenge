class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0, ln = nums.length;
        
        for(int item: nums) {
            if(item==num1) count1++;
            else if(item==num2) count2++;
            else if(count1==0) {num1 = item; count1++;}
            else if(count2==0) {num2 = item; count2++;}
            else {count1--; count2--;}
        }
        count1=0; count2=0;
        List<Integer> ans = new ArrayList<Integer>();
        for(int item: nums) {
            if(item == num1) {count1++;}
            else if(item == num2) {count2++;}
        }
        if(count2>(ln/3)) ans.add(num2);
        if(count1>(ln/3)) ans.add(num1);
        return ans;
    }
}