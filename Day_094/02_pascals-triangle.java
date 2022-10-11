class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>last = new ArrayList<>();
        //if(numRows==1) return new ArrayList<>();
        last.add(1);
        ans.add(last);
        for(int i=2; i<=numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=0; j<last.size()-1; j++) {
               temp.add(last.get(j) + last.get(j+1));
           }
            temp.add(1);
            ans.add(temp);
            last = temp;
        }
        return ans;
    }
}