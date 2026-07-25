class Solution {
    public int maxProduct(int n) {
        int a=n%10;//first
        n/=10;
        int b=n%10;//secound
        n/=10;
        if(b>a){int temp=a;
                a=b;
                b=temp;}
        while(n!=0){
            int x=n%10;//new number
            n/=10;
            if(x>a){
                b=a;
                a=x;
            }else if(x>b){
                b=x;
            }
        }
        return a*b;
    }
}