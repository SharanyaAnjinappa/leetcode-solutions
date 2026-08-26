class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int n=s.length();
        int l=0;
        int ones=0;
        for(int r=0;r<n;r++){
            if(s.charAt(r)=='1'){ones++;}
            while(ones>k){
                if(s.charAt(l)=='1'){ones--;}
                l++;
            }
            if(ones==k){
                while(l<r && s.charAt(l)=='0'){l++;}
                String curr=s.substring(l,r+1);
                if(ans.isEmpty()||curr.length()<ans.length()||(curr.length()==ans.length()&&curr.compareTo(ans)<0)){ans=curr;}
            }
        }return ans;
    }
}