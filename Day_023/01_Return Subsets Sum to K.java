/*
    Time Complexity : O(N * (2 ^ N))
    Space Complexity :  O(N * (2 ^ N))

    Where 'N' denotes the number of elements in the array.
*/

import java.util.ArrayList;

public class Solution {
	public static void findSubsetsThatSumToKHelper(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curSubset, int k, int idx) {

		if (idx == arr.size()) {
			if (k == 0 && curSubset.size() != 0) {
				ans.add(curSubset);
			}
			return;
		}

		// Case when we do not include the current element in the subset.
		findSubsetsThatSumToKHelper(arr, ans, curSubset, k, idx + 1);
		
		// Case when we include the current element in the subset.
		ArrayList<Integer> curSubset1 = new ArrayList<>(curSubset);
                curSubset1.add(arr.get(idx));

		findSubsetsThatSumToKHelper(arr, ans, curSubset1, k - arr.get(idx), idx + 1);
	}

	public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
		// ArrayList to store the subsets that sum to k.
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		// ArrayList to store the current subset.
		ArrayList<Integer> curSubset = new ArrayList<>();

		findSubsetsThatSumToKHelper(arr, ans, curSubset, k, 0);

		return ans;
	}
}