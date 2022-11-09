class StockSpanner {

    private Stack<Integer> stack;
    private int i;
    private ArrayList<Integer> arr;
    public StockSpanner() {
        stack = new Stack();
        i = 0;
        arr = new ArrayList();
    }
    
    public int next(int price) {
        return prevGreaterElement(price);
    }

    private int prevGreaterElement(int price) {
        while(stack.size() > 0 && arr.get(stack.peek()) <= price) {
            stack.pop();
        }
        
        int ans = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
        arr.add(price);
        i++;

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */