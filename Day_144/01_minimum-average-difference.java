class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        double[] prefix = new double[n + 1]; // prefix[1] is sum up to i=1 exclusive [0, i)

        // A    =   [2, 3, 5] //
        // PS   =   [0, 2, 5, 10]
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int bestIndex = 0;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int prefixAverage = (int) Math.floor(prefix[i + 1] / (i + 1));
            int suffixAverage = (int) Math.floor((prefix[n] - prefix[i + 1]) / (n - i - 1));
            int averageDifference = Math.abs(
                    // taking sum up to index i inclusive (i+1 elements)
                    prefixAverage -
                    // taking sum from i+1:n (n-i elements)
                    suffixAverage
            );
            if (averageDifference < best) {
                best = averageDifference;
                bestIndex = i;
            }
        }

        return bestIndex;
    }
}