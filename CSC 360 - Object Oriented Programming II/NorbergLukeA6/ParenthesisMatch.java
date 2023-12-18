import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ParenthesisMatch {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(new File("brackets.txt"))) {
            while (input.hasNext()) {
                boolean isValid = isParenthesisMatch(input.nextLine());
                System.out.println(isValid);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static boolean isParenthesisMatch(String parenthesis) {
        var stack = new java.util.Stack<Character>();

        for (int i = 0; i < parenthesis.length(); i++) {
            if (parenthesis.charAt(i) == '(') {
                stack.push('(');
            } else if (parenthesis.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else
                    return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
