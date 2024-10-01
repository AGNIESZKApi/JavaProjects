package ToDoList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Methods {
    public static void zapiszPlik(String nazwaPliku) {
        try {
            PrintWriter plikWyjscia = new PrintWriter(nazwaPliku);
            plikWyjscia.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie udało sie zapisać pliku.");;
        }
    }

    public static String odczytajPlik(String nazwaPliku){
        File plik = new File(nazwaPliku);
        String odczyt = "";
        try {
            Scanner scanner = new Scanner(plik);
            while (scanner.hasNextLine()) {
                odczyt = odczyt + scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma pliku do odczytu.");
        }
        return odczyt;
    }

    public static void dodajZadanie(String nazwaPliku, String tekst) {
        try (FileWriter fileWriter = new FileWriter(nazwaPliku,true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(tekst);
        } catch (IOException e) {
            System.out.println("Nie udało się dodać zadania do listy" + e.getMessage());
        }
    }

    public static void usunZadanie(String nazwaPliku, String usuwaneZadanie) {
        try {
            // Odczytujemy wszystkie linie z pliku
            List<String> listaZadan = Files.readAllLines(Paths.get(nazwaPliku));
            StringBuilder nowaListaZadan = new StringBuilder();

            // Przetwarzamy każdą linię
            for (String linia : listaZadan) {
                // Usuwamy dany tekst z linii
                String zaktualizowaneZadanie = linia.replace(usuwaneZadanie, "");
                // Dodajemy zaktualizowaną linię do nowej zawartości
                nowaListaZadan.append(zaktualizowaneZadanie).append(System.lineSeparator());
            }
            try (FileWriter fileWriter = new FileWriter(nazwaPliku)) {
                fileWriter.write(nowaListaZadan.toString());
            }
            System.out.println("Tekst został usunięty z pliku.");
        } catch (IOException e) {
            System.out.println("Błąd");
        }

    }
    public static void usunPusteLinie(String nazwaPliku) {
        try {
            // Odczytaj wszystkie linie z pliku
            List<String> linie = Files.readAllLines(Paths.get(nazwaPliku));

            // Przefiltruj linie, usuwając te, które są puste lub zawierają tylko białe znaki
            List<String> przefiltrowaneLinie = linie.stream()
                    .filter(line -> !line.trim().isEmpty())
                    .collect(Collectors.toList());

            // Nadpisz oryginalny plik przefiltrowanymi liniami
            Files.write(Paths.get(nazwaPliku), przefiltrowaneLinie);
        } catch (IOException e) {
            System.out.println("Błąd podczas usuwania pustych linii z pliku.");
        }
    }
}
