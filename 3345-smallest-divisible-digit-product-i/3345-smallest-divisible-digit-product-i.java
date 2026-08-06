class Solution {
    public int smallestNumber(int n, int t) {
        int number=n;
        while(true){
            int pro=1;
            n=number;
            while(n>0){
                pro*=n%10;
                n/=10;
            }
            if(pro%t==0){break;}
            else number++;
        }
        return number;
    }
}