/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    Where 'N' is the number of trains.
*/

import java.util.Arrays;

public class Solution {

    static int calculateMinPatforms(int at[], int dt[], int n) {
        // Array to store the number of platforms required at different points of time.
        int platforms[] = new int[2361];
        Arrays.fill(platforms, 0);

        // Variable to store the final answer i.e. minimum number of platforms required.
        int minNumOfPlatforms = 1;

        for (int i = 0; i < n; i++) {

            // Increment the count of platforms at the time of arrival.
            ++platforms[at[i]];

            // Decrease the platform count just after the departure.
            --platforms[dt[i] + 1];
        }

        // We are running loop till 2361 because maximum time value in a day can be 23:60.
        for (int i = 1; i < 2361; i++) {

            // Taking cumulative sum of platforms.
            platforms[i] = platforms[i] + platforms[i - 1];

            // Update minNumOfPlatforms.
            minNumOfPlatforms = Math.max(minNumOfPlatforms, platforms[i]);
        }

        // Return the minimum number of platforms.
        return minNumOfPlatforms;
    }

}