package recursion;

import java.util.Stack;

// Hanoi Towers problem. Cracking the coding interview

class Tower {
    private Stack<Integer> stack = new Stack<>();

    public Tower(int numDisks) {
        for(int j = numDisks; j > 0; j--) {
            addDisk(j);
        }
    }

    public void addDisk(int size) {
        if (!stack.isEmpty() && stack.peek() <= size) {
            System.err.println("Error placing disk ");
            return;
        }
        stack.push(size);
    }

    public int removeDisk() {
        return stack.pop();
    }

    public int size() {
        return stack.size();
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n <= 0) {
            return;
        }

        moveDisks(n - 1, buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n - 1,destination, this);
    }

    public void moveTopTo(Tower t) {
        int disk = removeDisk();
        t.addDisk(disk);
    }
}

public class Hanoi {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Tower tOrigin = new Tower(n);
        Tower tBuffer = new Tower(0);
        Tower tDestination = new Tower(0);

        System.out.println(tOrigin.size());
        System.out.println(tDestination.size());

        tOrigin.moveDisks(n,tDestination,tBuffer);

        System.out.println(tOrigin.size());
        System.out.println(tDestination.size());
    }
}
