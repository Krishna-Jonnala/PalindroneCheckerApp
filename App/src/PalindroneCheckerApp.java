import java.util.Scanner;

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Palindrome Checker App Management System");
        System.out.print("Enter a string: ");

        String originalString = scanner.nextLine();
        String reversedString = "";

        // Reverse string using for loop
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i);
        }

        // Compare original and reversed string
        if (originalString.equals(reversedString)) {
            System.out.println("It is a palindrome!");
        } else {
            System.out.println("It is NOT a palindrome.");
        }

        scanner.close();
    }
}