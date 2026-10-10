class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] freq = new int[100001];
        long total = 0;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            total += diff;
            mx = Math.max(mx, diff);
        }
        long k = (long)k1 + k2;
        if (total <= k) return 0;
        for(int d=mx;d>0 && k>0;d--){
            int moves=(int) Math.min(k,(long) freq[d]);
            freq[d]-=moves;
            freq[d-1]+=moves;
            k-=moves;
        }
        long ans=0;
        for(int d=1;d<=mx;d++){
            ans+=(long)d*d*freq[d];
        }
        return ans;
    }
}