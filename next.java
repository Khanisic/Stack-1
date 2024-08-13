// Time Complexity : 0(2 * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) { // mod to stay within limit
                int popped = s.pop();
                res[popped] = nums[i % n];
            }
            if (!s.isEmpty() && i % n == s.peek()) { // optimizing condition
                break;
            }
            if (i < n) {
                s.push(i);
            }
        }

        return res;
    }
}