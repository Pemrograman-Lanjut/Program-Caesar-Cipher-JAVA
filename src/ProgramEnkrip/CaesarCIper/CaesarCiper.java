package ProgramEnkrip.CaesarCIper;

import java.util.Scanner;

public class CaesarCiper {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String text, int shiftKey) {
        text = text.toLowerCase();
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                int position = ALPHABET.indexOf(character);
                int newPosition = (position + shiftKey) % 26;
                encryptedText.append(ALPHABET.charAt(newPosition));
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String text, int shiftKey) {
        text = text.toLowerCase();
        StringBuilder decryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                int position = ALPHABET.indexOf(character);
                int newPosition = (position - shiftKey) % 26;
                if (newPosition < 0) {
                    newPosition += ALPHABET.length();
                }
                decryptedText.append(ALPHABET.charAt(newPosition));
            } else {
                decryptedText.append(character);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to encrypt or decrypt? (E/D): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("E")) {
            System.out.print("Enter the text to encrypt: ");
            String text = scanner.nextLine();
            System.out.print("Enter the shift key: ");
            int shiftKey = scanner.nextInt();
            System.out.print("Encrypted text: " + encrypt(text, shiftKey));
        } else if (choice.equalsIgnoreCase("D")) {
            System.out.print("Enter the text to decrypt: ");
            String text = scanner.nextLine();
            System.out.print("Enter the shift key: ");
            int shiftKey = scanner.nextInt();
            System.out.print("Decrypted text: " + decrypt(text, shiftKey));
        } else {
            System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }
}