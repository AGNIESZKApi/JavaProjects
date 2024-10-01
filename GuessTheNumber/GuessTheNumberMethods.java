package GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberMethods {
    public static int giveNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę z zakresu 0-100: ");
        int number = scanner.nextInt();
        return number;
    }
}

