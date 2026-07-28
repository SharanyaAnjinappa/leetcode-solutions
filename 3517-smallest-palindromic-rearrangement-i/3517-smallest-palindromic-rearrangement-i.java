class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int[] count=new int[26];
        char[] ans=s.toCharArray();
        for(int i=0;i<n/2;i++){
            count[s.charAt(i)-'a']++;
        }int idx=0;
        for(int i=0;i<26;i++){
            while(count[i]>0){
                ans[idx++]=(char)(i+'a');
                count[i]--;
            }
        }
        for(int i=0;i<n/2;i++){
            ans[n-1-i]=ans[i];
        }
        return new String(ans);
    }
}