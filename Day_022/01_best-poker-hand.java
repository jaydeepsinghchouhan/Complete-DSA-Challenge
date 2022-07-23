class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Arrays.sort(ranks);
        int count=1;int maxCount = 0;
        int temp = ranks[0];
        for(int i=1; i<5; i++) {
            if(ranks[i] == temp) {
                count++;
            }
            else {
                maxCount = Math.max(count,maxCount);
                count = 1;
                temp = ranks[i];
            }
        }
        maxCount = Math.max(count,maxCount);
        
        if(maxCount >= 3)   return "Three of a Kind";
        
        else if(maxCount == 2)  return "Pair";
        
        char temp1 = suits[0];
        for(int i=1; i<5; i++) {
            if(suits[i] != temp1) {
                return "High Card";
            }
        }
        return "Flush";
    }
}