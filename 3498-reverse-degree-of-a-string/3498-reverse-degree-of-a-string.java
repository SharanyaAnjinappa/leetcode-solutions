class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int alphabet=ch-'a'+1;//26-26+1=1
            int reverse=27-alphabet;//27-1=26
            int pos=i+1;//i=1;
            int product=reverse*pos;//26*1;
            sum=sum+product;
        }
        return sum;
    }
}