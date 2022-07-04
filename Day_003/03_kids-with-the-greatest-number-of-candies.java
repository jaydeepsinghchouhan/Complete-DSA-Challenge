class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int ln = candies.length;
        List <Boolean> result = new ArrayList<>(ln);
        for(int i=0; i<ln; i++) {
            max = Math.max(max,candies[i]);
        }
        for(int i=0; i<ln; i++) {
            if(max<=candies[i]+extraCandies)
                result.add(true);
            else result.add(false);
        }
        
        return result;
    }
}