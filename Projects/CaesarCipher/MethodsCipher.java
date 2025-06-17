package CaesarCipher;

import java.util.Scanner;

public class MethodsCipher {
    public static String giveText(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tekst do zaszyfrowania: ");
        String text = scanner.nextLine();
        return text;
    }
    public static String encryption(String text, int movement) {
        StringBuilder encrypted = new StringBuilder();
        movement = movement % 26;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
//            int alfphabetPosition = Character.toLowerCase(ch) - 'a' + 1;
//            System.out.print(alfphabetPosition + " ");
            if (ch >= 'a' && ch <= 'z') {
                char encryptedChar = (char) (ch + movement);
                if (encryptedChar > 'z') {
                    encryptedChar -= 26;
                }
                encrypted.append(encryptedChar);
            }
            else if (ch >= 'A' && ch <= 'Z') {
                char encryptedChar = (char) (ch + movement);
                if (encryptedChar > 'Z') {
                    encryptedChar -= 26;
                }
                encrypted.append(encryptedChar);
            }
            else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public static String decryption(String text, int movement) {
        return encryption(text, 26 - movement);
    }
}