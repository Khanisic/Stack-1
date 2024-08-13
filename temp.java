// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> st = new Stack<>();
        st.push(new int[] { 0, temperatures[0] });
        for (int i = 1; i < n; i++) {
            int[] peek = st.peek();
            while (!st.isEmpty() && temperatures[i] > peek[1]) {
                st.pop();
                res[peek[0]] = i - peek[0];
                if (!st.isEmpty()) {
                    peek = st.peek();
                }
            }
            st.push(new int[] { i, temperatures[i] });
        }
        return res;
    }
}


// second apporach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()] ) {
                int popped = st.pop();
                res[popped] = i - popped;
            }
            st.push(i);
        }
        return res;
    }
}