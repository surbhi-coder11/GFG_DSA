import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Direction vectors for: Right, Down, Left, Up (Clockwise order)
        int[][] directions = {
            {0, 1},  // Right
            {1, 0},  // Down
            {0, -1}, // Left
            {-1, 0}  // Up
        };
        
        int r = 0, c = 0; // Start at the top-left corner
        int dir = 0;      // Initially moving Right
        
        while (true) {
            // Rule: If 1 is encountered, change direction to right and update cell to 0
            if (mat[r][c] == 1) {
                mat[r][c] = 0;
                dir = (dir + 1) % 4; // Turn clockwise
            }
            
            // Calculate next coordinates
            int nextR = r + directions[dir][0];
            int nextC = c + directions[dir][1];
            
            // Check if the next step goes out of boundaries
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                break; // Current (r, c) is the exit point
            }
            
            // Move to the next cell
            r = nextR;
            c = nextC;
        }
        
        // Prepare the output result
        List<Integer> result = new ArrayList<>();
        result.add(r);
        result.add(c);
        return result;
    }
}