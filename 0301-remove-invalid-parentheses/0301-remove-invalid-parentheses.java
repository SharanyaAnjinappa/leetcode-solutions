class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(s);
        visited.add(s);
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }
            
            // If we found a valid string at this level, don't generate strings with MORE removals
            if (found) continue;
            
            // Generate all possible states by removing exactly one character
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                
                String nextState = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}