class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, long[]> maps = new HashMap<>();

        long ans = 0l;

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && stack.peek() >= arr[i]) maps.remove(stack.pop());
            
            long[] idx = {-1l, 0l};
            if(!stack.isEmpty()) idx = maps.get(stack.peek());
            maps.put(arr[i], new long[]{i, ((arr[i] * (i - idx[0])) + idx[1])%mod});
            ans = (ans + maps.get(arr[i])[1])%mod;
            stack.push(arr[i]);
        }

        return (int)ans;
    }
}