/*
    Time Complexity: O(N * logN)
    Space Complexity: O(N)

    Where N is the number of activities.
*/

import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;
import java.util.Comparator;


public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> finish) {
        int n = start.size();
        List<Pair<Integer, Integer>> activity = new ArrayList<Pair<Integer, Integer>>();

        for (int i = 0; i < n; i++){   
            Pair <Integer, Integer> temp =  new Pair <Integer, Integer> (finish.get(i), start.get(i)); 
            activity.add(temp);
        }

        // Sort the meetings according to their Finishing Time.
        activity.sort(new Comparator<Pair<Integer, Integer>>() {    
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());  
            }               
        });

        int maxActivity = 1;
        int currentTime = activity.get(0).getKey();

        for(Pair<Integer, Integer> p: activity) {
            // Find the next meeting available.
            if (p.getValue() >= currentTime) {
                maxActivity++;
                currentTime = p.getKey();
            }
        }
        return maxActivity;
    }

}


