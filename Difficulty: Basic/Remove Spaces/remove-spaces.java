class Solution {
    String removeSpaces(String s) {
        // code here
        s = s.replaceAll("\\s", "");
        return s;
    }
}