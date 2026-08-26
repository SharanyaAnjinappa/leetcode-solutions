class Solution {
    public boolean search(int[] nums, int target) {
        /*for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;*/
        int l=0,h=nums.length-1;
        while(l<=h){
            int m=(l+h)/2;
            if(nums[m]==target){return true;}
            if(nums[l]==nums[m]){
                l++;
                continue;
            }
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && target<=nums[m]){h=m-1;}
                else{l=m+1;}
            }
            else{
                if(nums[m]<=target && target<=nums[h]){l=m+1;}
                else{h=m-1;}
            }
        }return false;
    }
}