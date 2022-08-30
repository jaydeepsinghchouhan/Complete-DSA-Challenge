class Solution {
    public int maximumPopulation(int[][] logs) {
        int[]arr = new int[101];
        
        for(int[]i:logs) {
            int by = i[0];
            int dy = i[1];
            arr[by-1950]++;
            arr[dy-1950]--;
        }
        int max = arr[0];
        int maxY = 1950;
        for(int i=1; i<101; i++) {
            arr[i] = arr[i]+arr[i-1];
            if(max<arr[i]) {
                max = arr[i];
                maxY = 1950+i;
            }
        }
        return maxY;
    }
}