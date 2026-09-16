class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        
         ArrayList<Integer> span = new ArrayList<>();
         s.push(0);
         span.add(1);
        
        for(int i=1;i<arr.length;i++){
            
            int curr = arr[i];
            while(!s.isEmpty() && curr>=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span.add(i+1);
            }else{
                span.add(i-s.peek());
            }
            s.push(i);
        }
        return span;
        
    }
}