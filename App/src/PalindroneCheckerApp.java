import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker App - UC6 (Queue + Stack)");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Push and Enqueue characters
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO (Enqueue)
        }

        boolean isPalindrome = true;

        // Compare Dequeue and Pop
        for (int i = 0; i < input.length(); i++) {

            char fromStack = stack.pop();      // Pop (LIFO)
            char fromQueue = queue.remove();   // Dequeue (FIFO)

            if (fromStack != fromQueue) {
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