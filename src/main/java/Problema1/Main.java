package Problema1;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Metoda pentru a salva lista de perechi de numere într-un fișier JSON
    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/PerecheNumere.json");
            mapper.writeValue(file, lista);
            System.out.println("Lista a fost salvată în PerecheNumere.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda pentru a încărca lista de perechi de numere din fișierul JSON
    public static List<PerecheNumere> citire() {
        try {
            File file = new File("src/main/resources/PerecheNumere.json");
            if (!file.exists()) {
                System.out.println("Fișierul JSON nu există la calea specificată: " + file.getAbsolutePath());
                return new ArrayList<>();
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Programul principal
    public static void main(String[] args) {
        // Crearea listei de perechi de numere
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(8, 13));  // Exemplu: numere consecutive în Fibonacci
        lista.add(new PerecheNumere(12, 15)); // Exemplu: numere cu suma cifrelor egală
        lista.add(new PerecheNumere(22, 24)); // Exemplu: numere cu același număr de cifre pare

        // Scrierea listei în fișier
        scriere(lista);

        // Citirea din fișier și afișarea perechilor de numere
        List<PerecheNumere> citita = citire();
        if (citita != null && !citita.isEmpty()) {
            for (PerecheNumere pereche : citita) {
                System.out.println(pereche);
                System.out.println("Numere consecutive în Fibonacci: " + pereche.suntConsecutiveFibonacci());
                System.out.println("CMMMC: " + pereche.cmmmc());
                System.out.println("Suma cifrelor egală: " + pereche.sumaCifre());
                System.out.println("Numărul de cifre pare egale: " + pereche.cifrePare());
            }
        } else {
            System.out.println("Lista citită este goală sau nu a putut fi încărcată.");
        }
    }
}
