class Solution {
    public String[] createGrid(int m, int n) {
        String[] res=new String[m];
        /*res[0]=".".repeat(n);
        String row="#".repeat(n-1)+".";
        for(int i=1;i<m;i++){
            res[i]=row;
        }
        return res;*/
        var sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        res[0]=sb.toString();
        sb= new StringBuilder();
        for(int i=0;i<n-1;i++){
            sb.append("#");}
        sb.append(".");
        for(int i = 1; i < m; i++) {
            res[i] = sb.toString();
        }
        return res;
    }
}