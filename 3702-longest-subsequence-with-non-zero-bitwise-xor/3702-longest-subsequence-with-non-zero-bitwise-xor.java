class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        int zerocount=0;
        for(int num:nums){
            xor^=num;
            if(num==0){
                zerocount++;
            }
        }
            if(xor!=0){return n;}
            if(zerocount==n){return 0;}
            return n-1;
    }
}
