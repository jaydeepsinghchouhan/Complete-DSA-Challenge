class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>winner=new ArrayList<>();
        List<Integer>looser=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<matches.length;i++)
        {
            map.put(matches[i][1],map.getOrDefault(matches[i][1],0)+1);
        }
        for(int j=0;j<matches.length;j++)
        {
            if(!map.containsKey(matches[j][0]))
            {
                winner.add(matches[j][0]);
                map.put(matches[j][0],2);
            }
           if( map.get(matches[j][1])==1)
            {
                looser.add(matches[j][1]);
                map.put(matches[j][1],2);
            }
        }
      /* for(int j=0;j<matches.length;j++)
        {
            if(map.get(matches[j][1])==1)
            {
                looser.add(matches[j][1]);
            }
        }*/
        Collections.sort(looser);
         Collections.sort(winner);
        ans.add(winner);
        ans.add(looser);
        return ans;
    }
}