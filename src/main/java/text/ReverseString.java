package text;

/**
 * Created by MHSL on 03.02.2017.
 *
 * Reverse a String - Enter a string and the program will reverse it and print it out.
 */
public class ReverseString {
    
    private static final String INPUT_LINE = "It's a some line what I want to reverse.";
    
    public static void main(String[] args) {
        System.out.println(reverseString(INPUT_LINE));
        System.out.println(cheatReverseString(INPUT_LINE));
    }
    
    public static String reverseString(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            builder.append(string.charAt(i));
        }
        return builder.toString();
    }
    
    public static String cheatReverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
