import java.util.Stack;

public class PostfixEvaluation {

    // Method to evaluate the value of a postfix expression
    static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the character is a number, push it to the stack
            if (Character.isDigit(c))
                stack.push(c - '0');

            // If the character is an operator, pop two operands and apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println("Postfix Evaluation: " + evaluatePostfix(exp));
    }
}