class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int n=s.length();
        for(int i=0;i<n;i++){
            int onecount=0;
            StringBuilder current=new StringBuilder();
            for(int j=i;j<n;j++){
                current.append(s.charAt(j));
                if(s.charAt(j)=='1'){onecount++;}
                if(onecount>k){break;}
                if(onecount==k){
                    String currstring=current.toString();
                    if(ans.isEmpty()||currstring.length()<ans.length()||(currstring.length()==ans.length() && currstring.compareTo(ans)<0)){ans=currstring;}
                }
            }
        }return ans;
    }
}