class Solution {

    public void helper(int ob,int cb, StringBuilder sb, List<String> result){
        if(ob==0 && cb==0){
            result.add(sb.toString());
            return;
        }
        if(ob==cb && ob!=0 && cb!=0){
            sb.append('(');
            helper(ob-1,cb,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }else if(ob<cb){
            if(ob!=0){
                sb.append('(');
                helper(ob-1,cb,sb,result);
                sb.deleteCharAt(sb.length()-1);
            }
            if(cb!=0){
                sb.append(')');
                helper(ob,cb-1,sb,result);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        helper(n,n,sb,result);        
        return result;
    }
}