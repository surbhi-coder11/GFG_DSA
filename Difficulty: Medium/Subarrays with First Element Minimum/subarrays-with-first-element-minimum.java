class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            int next = st.isEmpty() ? n : st.peek();
            ans += next - i;

            st.push(i);
        }

        return ans;
    }
}
