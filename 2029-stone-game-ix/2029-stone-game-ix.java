class Solution {
    public boolean stoneGameIX(int[] stones) {
        int zeros=0;
        int ones=0;
        int twos=0;
        for(int i=0;i<stones.length;i++){
            int n=stones[i]%3;
            if(n==0){zeros++;}
            else if(n==1){ones++;}
            else{twos++;}
        }
        if(ones==0 && twos==0){return false;}
        if(zeros%2==0){return ones>0 && twos>0;}
        return Math.abs(ones - twos) > 2;
    }
}