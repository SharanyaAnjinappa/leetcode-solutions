class Solution {
    public int largestInteger(int[] nums, int k) {
       /*  HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<=nums.length-k;i++){
            HashSet<Integer> seen=new HashSet<>();
            for(int j=i;j<i+k;j++){
                seen.add(nums[j]);
            }
            for(int num:seen){
                map.put(num,map.getOrDefault(num,0)+1);
            }}
             int ans=-1;
            for(int num:map.keySet()){
                if(map.get(num)==1){ans=Math.max(ans,num);}
            }
        return ans;*/

        int n=nums.length;
        int ans=-1;
        int[] freq=new int[51];
        for(int i:nums){
            freq[i]++;
        }
        for(int i=0;i<n;i++){
            if(k==n || (freq[nums[i]]==1 && (k==1||i==0||i==n-1))){ans=Math.max(ans,nums[i]);}
        }
        return ans;
    }
}