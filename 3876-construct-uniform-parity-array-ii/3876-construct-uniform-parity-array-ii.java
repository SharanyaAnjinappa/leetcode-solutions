class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        int oddcnt=0;
        for(int x:nums1){
            min=Math.min(min,x);
            if(x%2==1){oddcnt++;}
        }
        return min%2!=0 || oddcnt==0;
    }
}