class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count=new int[26];
        int l=0;
        int maxlen=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            count[ch-'a']++;
            while(count[ch-'a']>2){
                count[s.charAt(l)-'a']--;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}