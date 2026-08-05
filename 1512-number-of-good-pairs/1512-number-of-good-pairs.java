class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        int[] fre=new int[101];
        for(int num:nums){
            count+=fre[num];
            fre[num]++;
        }
        return count;
    }
}