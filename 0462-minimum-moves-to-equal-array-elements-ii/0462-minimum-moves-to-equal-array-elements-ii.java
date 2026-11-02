class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        /*int n=nums.length;
        int median = nums[n / 2];
        long moves = 0;
        for (int i=0;i<n/2;i++) {
            moves += Math.abs(nums[i] - median);
            moves+=Math.abs(nums[n-i-1]-median);
        }
        return (int) moves;*/
        int i = 0, j = nums.length-1;
        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }
}