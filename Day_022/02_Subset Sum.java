/*
    Time Complexity:  O(2^N).
    Space Complexity:O(N).

    Where 'N' is the size of the array.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static ArrayList<Integer> ans;

    private static void subset(int i, int sum, int[] num) {
        // Completely traverse the whole array, insert the "sum" in the "ans" vector.
        if (i == num.length) {
            ans.add(sum);
            return;
        }

        // Insert the element in the sum.
        subset(i + 1, sum + num[i], num);
        // Don't take the element in the sum.
        subset(i + 1, sum, num);
    }

    public static ArrayList<Integer> subsetSum(int num[]) {

        // Ans array contains all the subset sums.
        ans = new ArrayList<Integer>();

        subset(0, 0, num);

        // Sort the vector and finally return it.
        Collections.sort(ans);
        return ans;
    }
}