class Solution {
    private final char mul = '*';
    private final char sub = '-';
    private final char add = '+';
    private String expression;
    private char a[];
    Set<Character> set;
    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        set = new HashSet<>();
        set.add(mul);
        set.add(add);
        set.add(sub);
        a = expression.toCharArray();
        return dfs(0, a.length - 1);
    }
    public List<Integer> dfs(int start, int end) {
        List<Integer> ans = new ArrayList<>();
        for(int i = start; i < end; i ++) {
            if(set.contains(a[i])) {
                List<Integer> left = dfs(start, i-1);
                List<Integer> right = dfs(i + 1, end);
                for(Integer i1 : left) {
                    for(Integer i2 : right) {
                        int val = calculate(i1, i2, a[i]);
                        ans.add(val);
                    }
                }
            }
        }
        if(ans.size() == 0)
            ans.add(Integer.parseInt(expression.substring(start, end + 1)));
        return ans;
    }
    public int calculate(int a, int b, char oper) {
        switch(oper) {
            case mul:
                return a * b;
            case add:
                return a + b;
            case sub:
                return a - b;
            default:
                return -1;
        }
    }
}