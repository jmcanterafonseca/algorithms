package string;// Count the number of blank spaces

/* URLfy spaces of a string by substituting it by %20 */

public class Exercise3 {
    public static void main(String[] args) {
        assert args.length > 0 :  "Argument is needed";

        System.out.println(args[0]);

        char[] source = args[0].toCharArray();

        char[] c = new char[args[0].length() + 10];
        System.arraycopy(source,0,c,0,source.length);

        String out = urlFy(c,args[0].length());

        System.out.println(out);
    }

    // O(n)
    public static String urlFy(char[] cArray,int effectiveLenght) {
        int strStart = effectiveLenght - 1;
        int targetCharPointer = cArray.length -  1;
        int outStrStarts = targetCharPointer;

        for(int j = strStart; j >= 0; j--) {
            if (cArray[j] == ' ') {
                cArray[targetCharPointer] = '0';
                cArray[targetCharPointer -  1] = '2';
                cArray[targetCharPointer -  2] = '%';
                outStrStarts = targetCharPointer;
                targetCharPointer-=3;
            }
            else {
                cArray[targetCharPointer] = cArray[j];
                outStrStarts = targetCharPointer;
                targetCharPointer--;
            }
        }

        return new String(cArray,outStrStarts,cArray.length - outStrStarts);
    }
}
