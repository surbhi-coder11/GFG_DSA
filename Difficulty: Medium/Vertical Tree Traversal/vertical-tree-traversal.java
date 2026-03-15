/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static class Pair{
        Node node ;
        int hd;
        Pair(Node node , int hd){
            this.node = node ;
            this.hd = hd;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            Node node = curr.node;
            int hd = curr.hd;
            map.putIfAbsent(hd,new ArrayList<>());
            map.get(hd).add(node.data);
            
            if(node.left != null){
              q.offer(new Pair(node.left , hd-1));  
            }
            if(node.right != null){
                q.offer(new Pair(node.right , hd+1));
            }
        }
        for(ArrayList<Integer> list : map.values()){
            ans.add(list);
        }
        
        return ans;
        
    }
}