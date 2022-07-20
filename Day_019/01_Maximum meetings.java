/*
    Time Complexity: O(N * logN)
    Space Complexity: O(N)

    Where N is the number of meetings.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class meet {
    int meetingID;
    int startTime;
    int endTime;

    public meet(int val) {
        this.meetingID = val;
        this.startTime = val;
        this.endTime = val;
    }

}

public class Solution {

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        int n = start.length;

        List<meet> meeting = new ArrayList<meet>();

        for (int i = 0; i < n; i++) {   
            meet temp =  new meet(0);
            temp.meetingID = i+1;
            temp.startTime = start[i];
            temp.endTime = end[i]; 
            meeting.add(temp);
        }

        // Sorting the meeting array in increasing order of end time using customized comparator.
        meeting.sort(new Comparator<meet>() {    
            @Override
            public int compare(meet o1, meet o2) {
                if(o1.endTime == o2.endTime){
                    return o1.meetingID - o2.meetingID;
                }
                return o1.endTime - o2.endTime; 
            }               
        });

        List<Integer> result = new ArrayList<Integer>();

        // Taking the first meeting of sorted array as our first meeting.
        result.add(meeting.get(0).meetingID);
        int currentTime = meeting.get(0).endTime;

        for (int i = 1; i < n; i++) {
            if (meeting.get(i).startTime > currentTime) {

                //If startTime of current meeting is greater than our currentTime.
                //Then we will perform this meeting and update currentTime with endTime of the meeting.
                result.add(meeting.get(i).meetingID);
                currentTime = meeting.get(i).endTime;
            }
        }

        return result;
    } 
}



