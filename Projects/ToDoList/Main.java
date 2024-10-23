package ToDoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String nazwaPliku = "C:\\Users\\agnie\\IdeaProjects\\projects\\src\\ToDoList\\todolist.txt";
        String odczytanyPlik = Methods.odczytajPlik(nazwaPliku);
        System.out.println("Na liście są następujące zadania: " + "\n" + odczytanyPlik);
        System.out.println("Czy chcesz coś zmienić na liście zadań? Wpisz \"usun zadanie\" lub \"dodaj zadanie\": ");
        Scanner scanner = new Scanner(System.in);
        String zmiana = scanner.nextLine();
        if (zmiana.equals("dodaj zadanie")) {
            System.out.println("Dodaj zadanie do listy: ");
            String tekst = scanner.nextLine();
            Methods.dodajZadanie(nazwaPliku,tekst);
        } else if (zmiana.equals("usun zadanie")) {
            System.out.println("Napisz które zadanie chcesz usunąć: ");
            String doUsuniecia = scanner.nextLine();
            Methods.usunZadanie(nazwaPliku, doUsuniecia);
        } else System.out.println("Nieprawidłowe polecenie");
        Methods.usunPusteLinie(nazwaPliku);

//        Methods.zapiszPlik(nazwaPliku);



    }
}
