class Solution {
    public boolean halvesAreAlike(String s) {
        int count =0, l=0, r=s.length()-1;
        char[] ch = s.toCharArray();

        while(l<=r){
            if(ch[l]=='u' || ch[l]=='o' || ch[l]=='i' || ch[l]=='e' || ch[l]=='a' || ch[l]=='U' || ch[l]=='O' || ch[l]=='I' || ch[l]=='E' || ch[l]=='A')
                count++;
            if(ch[r]=='u' || ch[r]=='o' || ch[r]=='i' || ch[r]=='e' || ch[r]=='a' || ch[r]=='U' || ch[r]=='O' || ch[r]=='I' || ch[r]=='E' || ch[r]=='A')
                count--;
            l++;
            r--;
        }
        return count==0;
    }
}