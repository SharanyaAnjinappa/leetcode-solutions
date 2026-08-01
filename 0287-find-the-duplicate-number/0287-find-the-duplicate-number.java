class Solution {
    public int findDuplicate(int[] nums) {
       /* int s=nums[0];
        int f=nums[0];
        do{
            s=nums[s];
            f=nums[nums[f]];
        } while(s!=f);
        s=nums[0];
        while(s!=f){
            s=nums[s];
            f=nums[f];
        }
        return s;*/

        int n=nums.length;
        int[] fre=new int[n+1];
        for(int i : nums){
            fre[i]++;
        }
        for(int i=1;i<=n;i++){
            if(fre[i]>1){return i;}
        }return -1;
    }
}