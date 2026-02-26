import java.util.Scanner;
import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker App - UC5 (Stack Based)");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop and compare
        for (int i = 0; i < input.length(); i++) {
            char poppedChar = stack.pop();

            if (input.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}