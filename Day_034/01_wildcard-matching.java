class Solution {
    HashMap<String,Boolean> hm = new HashMap<>();
    
    public boolean isMatch(String s, String p) {
        
        char ss[] = s.toCharArray();
        char pp[] = p.toCharArray();
          
        boolean ans = function(ss,pp,s.length(),p.length());
        System.out.println(hm);
        return ans;
    }
    
    public boolean function(char[] str,char[] patt, int n,int m)
    {
        if(n<=0 && m<=0)
        {
            return true;
        }else if(m<=0)
        {
            return false;
        }else if(n<=0)
        {
            for(int i=0;i<m;i++)
            {
                if(patt[i]!='*')
                    return false;
            }
            return true;
        }
        
         
        String k = Integer.toString(m)+Integer.toString(n);
        if(hm.containsKey(k))
        {
            return hm.get(k);
        }
        
        
        boolean ans = false;
        if(str[n-1]==patt[m-1] || patt[m-1]=='?')
        {
            ans = function(str,patt,n-1,m-1);
            hm.put(k,ans);
            return hm.get(k);
        }
        else if(patt[m-1]=='*')
        {
            ans = function(str,patt,n,m-1) || function(str,patt,n-1,m);
            hm.put(k,ans);
            return ans;
        }else {
            hm.put(k,false);
            return false;
        }
    }
}