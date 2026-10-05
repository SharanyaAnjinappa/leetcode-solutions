class Solution {
    public int scoreOfParentheses(String s) {
        /*Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(0);
            }
            else{
                int top=stack.pop();
                int A=Math.max(2*top,1);
                int B=stack.pop();
                tack.push(A+B);
            }
        }
        return stack.pop();*/
      
        int count = 0;
        int score = 0;
        for(int i =0;i<s.length();i++){
            //nested
            if(s.charAt(i)=='('){
                count++;
            }else{
                count--;
                if(s.charAt(i-1)=='('){
                    score+= 1<<count;
                }
            }
        }
        return score;
    
    }
}