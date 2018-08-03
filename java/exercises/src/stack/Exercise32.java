package stack;

/* A stack that is capable to return the min in O(1) */
/* Each StackNode contains the min of the substack that includes itself */
public class Exercise32 {
    public static void main(String[] args) {
        StackMin s = buildStack(args);

        System.out.println("Minimum: " + s.getMin());

        s.pop();
        s.pop();
        s.pop();

        System.out.println("Minimum: " + s.getMin());

        s.pop();
        System.out.println("Minimum: " + s.getMin());

        s = buildStack(args);
        printStack(s);
    }

    public static StackMin buildStack(String[] args) {
        StackMin s = new StackMin(args.length);

        for(String arg : args) {
            int val = Integer.parseInt(arg);
            s.push(val);
        }

        return s;
    }

    public static void printStack(StackMin s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
