package Problema1;



public class PerecheNumere {
    private int numar1;
    private int numar2;

    // Constructor fără parametri
    public PerecheNumere() {
        this.numar1 = 0;
        this.numar2 = 0;
    }

    // Constructor cu parametri
    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    // Getteri și setteri
    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    // Metoda pentru a verifica dacă cele două numere sunt consecutive în șirul Fibonacci
    public boolean suntConsecutiveFibonacci() {
        int a = 0, b = 1;
        while (b < numar1) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return (b == numar1 && a == numar2) || (a == numar1 && b == numar2);
    }

    // Metoda pentru calculul CMMMC
    public int cmmmc() {
        return (numar1 * numar2) / cmmmd(numar1, numar2);
    }

    // Metoda pentru calculul CMMMD (Cel Mai Mare Divizor Comun)
    private int cmmmd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Metoda pentru verificarea dacă suma cifrelor celor două numere este egală
    public boolean sumaCifre() {
        return sumaCifre(numar1) == sumaCifre(numar2);
    }

    // Metoda de calculare a sumei cifrelor
    private int sumaCifre(int numar) {
        int suma = 0;
        while (numar > 0) {
            suma += numar % 10;
            numar /= 10;
        }
        return suma;
    }

    // Metoda pentru verificarea dacă cele două numere au același număr de cifre pare
    public boolean cifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    // Metoda pentru calcularea numărului de cifre pare
    private int numarCifrePare(int numar) {
        int count = 0;
        while (numar > 0) {
            if ((numar % 10) % 2 == 0) {
                count++;
            }
            numar /= 10;
        }
        return count;
    }

    // Redefinirea metodei toString pentru a afisa perechea de numere
    @Override
    public String toString() {
        return "PerecheNumere{" +
                "numar1=" + numar1 +
                ", numar2=" + numar2 +
                '}';
    }
}
