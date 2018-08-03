package stack;

public class Stack {
    private int[] stack;
    int firstOutPointer = -1;

    public Stack(int size) {
        stack = new int[size];
    }

    public int pop() {
       if (isEmpty()) {
           throw new RuntimeException("Stack is empty");
       }

       int out = stack[firstOutPointer];
       // Reset
       stack[firstOutPointer] = 0;

       firstOutPointer--;

       return out;
    }

    public void push(int value) {
        if (firstOutPointer + 1 > stack.length - 1) {
            throw new RuntimeException("Stack is full");
        }
        firstOutPointer++;
        stack[firstOutPointer] = value;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[firstOutPointer];
    }

    public boolean isEmpty() {
        return (firstOutPointer == -1);
    }
}
