package GuessTheNumber;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int randomInt = random.nextInt(100);
        int giveNumber;
        while (true){
            giveNumber = GuessTheNumberMethods.giveNumber();
            if (giveNumber >= 0 && giveNumber <= 100) {
                while (giveNumber != randomInt) {
                    if (giveNumber < randomInt) {
                        System.out.println("Twoja liczba jest mniejsza od wylosowanej przez komputer. Spróbuj z inną liczbą.");
                        giveNumber = GuessTheNumberMethods.giveNumber();
//
                    } else if (giveNumber > randomInt) {
                        System.out.println("Twoja liczba jest większa od wylosowanej przez komputer. Spróbuj z inną liczbą.");
                        giveNumber = GuessTheNumberMethods.giveNumber();
                    } else System.out.println("Nie podałeś liczby");
                }
                System.out.println("Brawo, zgadłeś prawidłową liczbę!");
                break;
            }
            else System.out.println("Podałeś liczbę spoza zakresu 0-100");
        }
    }
}
