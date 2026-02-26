import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean isPalindrome(String text);
    }

    // Stack-based strategy
    static class StackStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String text) {
            Stack<Character> stack = new Stack<>();
            for (char c : text.toCharArray()) {
                stack.push(c);
            }
            for (char c : text.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    // Deque-based strategy
    static class DequeStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String text) {
            Deque<Character> deque = new LinkedList<>();
            for (char c : text.toCharArray()) {
                deque.addLast(c);
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    // String Reverse strategy
    static class ReverseStringStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String text) {
            String reversed = new StringBuilder(text).reverse().toString();
            return text.equals(reversed);
        }
    }

    // Utility to measure execution time of a strategy
    static long measureTime(PalindromeStrategy strategy, String input, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            strategy.isPalindrome(input);
        }
        long end = System.nanoTime();
        return (end - start) / iterations;  // average time per run
    }

    public static void main(String[] args) {

        String testString = "madamimadamimadamimadamimadamimadam"; // long palindrome for timing

        int iterations = 100_000;  // number of times to run for timing

        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new ReverseStringStrategy()
        };

        String[] strategyNames = {
                "Stack-based",
                "Deque-based",
                "String Reverse"
        };

        System.out.println("Performance Comparison of Palindrome Algorithms");
        System.out.println("Test string length: " + testString.length());
        System.out.println("Iterations per algorithm: " + iterations);
        System.out.println();

        for (int i = 0; i < strategies.length; i++) {
            long avgTime = measureTime(strategies[i], testString, iterations);
            System.out.printf("%-15s : %d ns (avg)\n", strategyNames[i], avgTime);
        }
    }
}