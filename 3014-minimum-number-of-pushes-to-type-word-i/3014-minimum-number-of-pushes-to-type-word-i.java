class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int ans=0;
        int count=1;
        while(n>=8){
            ans+=8*count;
            n-=8;
            count++;
        }
        ans+=n*count;
        return ans;
    }
}