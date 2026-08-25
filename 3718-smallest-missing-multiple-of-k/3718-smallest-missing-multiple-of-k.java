class Solution {
    public int missingMultiple(int[] nums, int k) {
        /*Set<Integer> seen=new HashSet<>();
        for(int num:nums){seen.add(num);}
        int curr=k;
        while(seen.contains(curr)){
            curr+=k;
        }
        return curr;*/
        for(int multiple=k;;multiple+=k){
            boolean found=false;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==multiple){
                    found=true;
                }
            }
            if(!found){return multiple;}
        }
    }
}