import java.util.Scanner;
import java.util.Stack;

// PalindromeChecker class encapsulates the logic
class PalindromeChecker {

    // Method to check palindrome using Stack internally
    public boolean checkPalindrome(String text) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker App - UC11 (OOP Service)");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}