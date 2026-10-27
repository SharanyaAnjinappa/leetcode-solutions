class Solution {
    public String[] createGrid(int m, int n) {
        String[] res=new String[m];
        res[0]=".".repeat(n);
        String row="#".repeat(n-1)+".";
        for(int i=1;i<m;i++){
            res[i]=row;
        }
        return res;
    }
}