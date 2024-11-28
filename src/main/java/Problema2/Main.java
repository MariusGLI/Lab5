package Problema2;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Mobilier> mobilierList = citireMobilier("src/main/resources/mobilier.json");

        // Afișează toate piesele de mobilier și plăcile lor
        afisareMobilier(mobilierList);

        // Afișează caracteristicile plăcilor pentru un anumit mobilier (de exemplu, "dulap 1")
        afisarePlaciMobilier("dulap 1", mobilierList);

        // Afișează numărul estimat de coli necesare pentru un anumit mobilier (de exemplu, "dulap 1")
        int coliiNecesare = calculeazaColiNecesare("dulap 1", mobilierList);
        System.out.println("Numărul de coli necesare pentru dulap 1: " + coliiNecesare);
    }

    public static List<Mobilier> citireMobilier(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Mobilier> mobilierList = new ArrayList<>();
        try {
            mobilierList = mapper.readValue(new File(filePath), new TypeReference<List<Mobilier>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mobilierList;
    }

    public static void afisareMobilier(List<Mobilier> mobilierList) {
        for (Mobilier mobilier : mobilierList) {
            System.out.println("Mobilier: " + mobilier.getNume());
            for (Placa placa : mobilier.getPlaci()) {
                System.out.println("  Placa: " + placa);
            }
        }
    }

    public static void afisarePlaciMobilier(String numeMobilier, List<Mobilier> mobilierList) {
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(numeMobilier)) {
                System.out.println("Mobilier: " + mobilier.getNume());
                for (Placa placa : mobilier.getPlaci()) {
                    System.out.println("  Placa: " + placa);
                }
                return;
            }
        }
        System.out.println("Nu s-a găsit mobilierul cu numele: " + numeMobilier);
    }

    public static int calculeazaColiNecesare(String numeMobilier, List<Mobilier> mobilierList) {
        final int SUPRAFATA_COLIE_PAL = 2800 * 2070;
        int suprafataNecesara = 0;

        for (Mobilier mobilier : mobilierList) {
            if (mobilier.getNume().equalsIgnoreCase(numeMobilier)) {
                for (Placa placa : mobilier.getPlaci()) {
                    int suprafataPlaca = placa.getLungime() * placa.getLatime() * placa.getNr_bucati();
                    suprafataNecesara += suprafataPlaca;
                }
                return (int) Math.ceil((double) suprafataNecesara / SUPRAFATA_COLIE_PAL);
            }
        }
        System.out.println("Nu s-a găsit mobilierul cu numele: " + numeMobilier);
        return 0;
    }
}