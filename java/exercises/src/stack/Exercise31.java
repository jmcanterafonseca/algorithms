package stack;

/* A simple stack implemented as an array */
/* A stack can also be implemented as LinkedList */
public class Exercise31 {
    public static void main(String[] args) {
        Stack s = buildStack(args);

        printStack(s);
    }

    public static Stack buildStack(String[] args) {
        Stack s = new Stack(args.length);

        for(String arg : args) {
            int val = Integer.parseInt(arg);
            s.push(val);
        }

        return s;
    }

    public static void printStack(Stack s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
