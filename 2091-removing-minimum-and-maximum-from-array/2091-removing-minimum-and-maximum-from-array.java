class Solution {
    public int minimumDeletions(int[] nums) {
        int min_index=0;
        int max_index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[min_index]){min_index=i;}
            if(nums[i]>nums[max_index]){max_index=i; }
        }
        int left=Math.min(min_index,max_index);
        int right=Math.max(min_index,max_index);
        int front=right+1;
        int back=nums.length-left;
        int frontback=(left+1)+(nums.length-right);
        return Math.min(front,Math.min(back,frontback));
    }
}