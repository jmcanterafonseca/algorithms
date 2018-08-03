package stack;

public class StackMin {
    private class StackNode {
        public int value;
        public int minSubstack = Integer.MAX_VALUE;

        public StackNode(int value) {
            this.value = value;
        }
    }

    private StackNode[] stack;

    int topPointer = -1;


    public StackMin(int size) {
        stack = new StackNode[size];
    }

    public int getMin() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stack[topPointer].minSubstack;
    }

    public int pop() {
       if (isEmpty()) {
           throw new RuntimeException("Stack is empty");
       }

       int out = stack[topPointer].value;

       // Reset
       stack[topPointer].value = 0;
       stack[topPointer].minSubstack = Integer.MAX_VALUE;

       topPointer--;

       return out;
    }

    public void push(int value) {
        if (topPointer == stack.length - 1) {
            throw new RuntimeException("Stack is full");
        }

        int min = Integer.MAX_VALUE;
        if(topPointer >= 0) {
            min = stack[topPointer].minSubstack;
        }

        topPointer++;
        stack[topPointer] = new StackNode(value);

        if (value < min) {
            stack[topPointer].minSubstack = value;
        }
        else {
            stack[topPointer].minSubstack = min;
        }
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[topPointer].value;
    }

    public boolean isEmpty() {
        return (topPointer == -1);
    }

    public boolean isFull() {
        return topPointer + 1 == stack.length;
    }
}
