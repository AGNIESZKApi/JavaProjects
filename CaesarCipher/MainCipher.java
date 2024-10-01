package CaesarCipher;

import java.util.Scanner;

public class MainCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj tekst do zaszyfrowania: ");
        String text = scanner.nextLine();

        System.out.print("Podaj przesunięcie: ");
        int movement = scanner.nextInt();

        String encryptionText = MethodsCipher.encryption(text, movement);
        System.out.println("Zaszyfrowany tekst: " + encryptionText);

        String decryptionText = MethodsCipher.decryption(encryptionText, movement);
        System.out.println("Odszyfrowany tekst: " + decryptionText);

        scanner.close();
    }
}
