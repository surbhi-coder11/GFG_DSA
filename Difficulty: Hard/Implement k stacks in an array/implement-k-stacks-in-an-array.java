class kStacks {
    private int[] arr;   // Main array to store stack elements
    private int[] top;   // Array to store indexes of top elements of stacks
    private int[] next;  // Array to store next entry in slots/free list
    private int free;    // To store the beginning index of the free list

    public kStacks(int n, int k) {
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty (-1 indicates empty stack)
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        // Initialize all slots as free
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; // -1 indicates the end of the free list
    }

    // Push element x into stack i (0-indexed)
    public void push(int x, int i) {
        // Overflow check (though the problem guarantees valid queries within constraints)
        if (free == -1) {
            return;
        }

        // 1. Find the index of the first free slot
        int insertIdx = free;

        // 2. Update the free list pointer to the next free slot
        free = next[insertIdx];

        // 3. Link the new element to the old top of stack i
        next[insertIdx] = top[i];

        // 4. Update the top of stack i to the current insertion index
        top[i] = insertIdx;

        // 5. Put the element into the main array
        arr[insertIdx] = x;
    }

    // Pop element from stack i (0-indexed)
    public int pop(int i) {
        // Underflow check: if stack i is empty, return -1
        if (top[i] == -1) {
            return -1;
        }

        // 1. Find the index of the top element of stack i
        int popIdx = top[i];

        // 2. Change top of stack i to the previous element in stack i
        top[i] = next[popIdx];

        // 3. Attach the popped slot to the beginning of the free list
        next[popIdx] = free;
        free = popIdx;

        // 4. Return the top element
        return arr[popIdx];
    }
}