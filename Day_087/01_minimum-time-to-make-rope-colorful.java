class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0; //result
        int len = colors.length(); 
        int l = 0,i = 1; //l- > for previous tracking //i for current
        while(i < len){ //iterating till i < len
            char prev = colors.charAt(l); //prev and curr color.
            char curr = colors.charAt(i);
            
            if(curr != prev){
                i++;l = i-1; //if both are diffrent i moves forward and since l is previous
                continue; // itt will be the elem just before i i.e. 'i-1'
            }
            
            //if color matches.
            if(neededTime[l] <= neededTime[i]){ //if previous takes less or equal time remove it.
                res += neededTime[l];  //add time to res.
                l = i; // since previous is removed. current will be our previous for next iteration.
            }else{
                res += neededTime[i]; //else if we remove current just add time to res.
            }
            i++; //move to the next element.
            
        }
        return res;
    }
}