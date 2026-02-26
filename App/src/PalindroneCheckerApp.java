import java.util.Scanner;

public class PalindroneCheckerApp {

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String text) {
        // Remove non-alphanumeric characters and convert to lowercase
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker App Management System");
        System.out.print("Enter a word or sentence: ");

        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("It is NOT a palindrome.");
        }

        scanner.close();
    }
}