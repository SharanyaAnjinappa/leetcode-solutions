class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            //Set<Integer> set=new HashSet<>();
            boolean[] seen= new boolean[101];
            int distint=0;
            for(int j=i;j<n;j++){
                /*set.add(nums.get(j));
                ans+=set.size()*set.size();*/
                int num=nums.get(j);
                if(!seen[num]){
                    seen[num]=true;
                    distint++;
                }
                ans+=distint*distint;
            }
        } return ans;
    }
}