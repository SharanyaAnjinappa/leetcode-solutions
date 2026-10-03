class Solution {
    public int longestValidParentheses(String s) {
        /*int ans=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){st.push(i);}
            else{st.pop();
                if(st.isEmpty()){st.push(i);}
                else{ ans=Math.max(ans,i-st.peek());}
            }
        }
        return ans;*/
        int n=s.length();
        int[] stack=new int[n+1];
        int top=-1;
        stack[++top]=-1;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){stack[++top]=i;}
            else{top--;
                if(top==-1){stack[++top]=i;}
                else{ans=Math.max(ans,i-stack[top]);}
            }
        }
        return ans;
    }
}