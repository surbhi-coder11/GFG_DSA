class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        Deque<String> q = new ArrayDeque<>();
        ArrayList<String> arr = new ArrayList<>();
        q.add("1");
        while(n-->0){
            String curr = q.remove();
            arr.add(curr);
            q.add(curr+"0");
            q.add(curr+"1");
        }
        
        return arr;
    }
}
