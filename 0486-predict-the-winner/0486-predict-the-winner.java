/*class Solution {
    public boolean dfs(int l,int r,int p1,int p2,boolean turn ,int[] nums){
        if(l>r) return p1>=p2;
        if(turn){return dfs(l+1,r,p1+nums[l],p2,false,nums)||dfs(l,r-1,p1+nums[r],p2,false,nums);}  
        else{return dfs(l+1,r,p1,p2+nums[l],true,nums)&&dfs(l,r-1,p1,p2+nums[r],true,nums);}  
    }
    public boolean predictTheWinner(int[] nums) {
        return dfs(0,nums.length-1,0,0,true,nums);
   
} }*/
class Solution {

    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int[] dp = nums.clone(); 
        
        for (int diff = 1; diff < n; ++diff) {
            for (int j = n - 1; j - diff >= 0; --j) {
                int i = j - diff;
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        return dp[n - 1] >= 0;
    }
}