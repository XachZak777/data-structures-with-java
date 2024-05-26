package dsHomework1;

public class StackSort {
    private int[] stack;
    private int top;

    public StackSort(int size) {
        stack = new int[size];
        top = -1;
    }

    public boolean isEmpty() { return top == -1; }

    public boolean isFull() { return top == stack.length - 1; }

    public void push(int value) {
        if (!isFull()) {
            stack[++top] = value;
        } else {
            throw new RuntimeException("Stack overflow");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            throw new RuntimeException("Stack underflow");
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            throw new RuntimeException("Stack underflow");
        }
    }

    public int size() { return top + 1; }

    public void sortStack() {
        for (int i = 0; i < size(); i++) {
            int maxIndex = findMaxIndex(size() - i);
            moveMaxToTop(maxIndex, size() - i);
        }
    }

    private int findMaxIndex(int limit) {
        int maxIndex = 0;
        for (int i = 1; i < limit; i++) {
            if (stack[i] > stack[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void moveMaxToTop(int maxIndex, int limit) {
        int maxValue = stack[maxIndex];
        for (int i = maxIndex; i < limit - 1; i++) {
            stack[i] = stack[i + 1];
        }
        stack[limit - 1] = maxValue;
    }
}

