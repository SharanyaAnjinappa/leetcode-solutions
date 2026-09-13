class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int overlap=0;
        for(int down=-(n-1);down<=n-1;down++){
            for(int right=-(n-1);right<=n-1;right++){
                int cnt_overlap=0;
                for(int row=0;row<n;row++){
                    for(int col=0;col<n;col++){
                        if(img1[row][col]==1){
                            int new_row=row+down;
                            int new_col=col+right;
                            if(new_row>=0 && new_row<n && new_col>=0 && new_col<n && img2[new_row][new_col]==1){
                                cnt_overlap++;
                            }
                        }
                    }
                } overlap=Math.max(overlap,cnt_overlap);
            }
        }
        return overlap;
    }
}