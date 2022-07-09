class Solution {
        public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==0) return new int[0][0];
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] temp = intervals[i];
            int j = i+1;
            while(j<n && intervals[j][0]<=temp[1]){
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j+=1;
            }
            i = j - 1;
            res.add(temp);
        }
        int m = res.size();
        return res.toArray(new int[m][2]);
    }
}
