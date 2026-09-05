class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] suffix_min=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<min){min=nums[i];}
            suffix_min[i]=min;
        }
        int prefix_max=0;
        for(int i=0;i<n;i++){
            if(nums[i]>prefix_max){prefix_max=nums[i];}
            if(prefix_max-suffix_min[i]<=k){return i;}
        }return -1;
    }
}