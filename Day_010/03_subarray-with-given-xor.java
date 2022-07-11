public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int xorr = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<A.size(); i++){
            xorr = xorr ^ A.get(i);
            if(xorr == B){
                count++;
            }
            if(map.containsKey(xorr^B)){
                count = count + map.get(xorr^B);
            }
            
            if(map.containsKey(xorr)){
                map.put(xorr, map.get(xorr) + 1);
            }else{
                map.put(xorr,  1);
            }
        }
        return count;
    }
}