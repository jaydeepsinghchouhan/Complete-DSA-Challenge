class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        
        for(int x: piles){
            queue.add(x);
            sum += x;
        }
        
        for(int i = 0; i < k; i++){
            int temp = queue.poll();
            queue.add(temp - temp/2);
            sum = sum -temp/2;
        }
        return sum;
    }        
}