package com.giray;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProjectAbasApp {
    public static void main(String[] args) {
        List<Siparis> siparisListesi = Arrays.asList(
                new Siparis(1000, 2000, 12, 100.51),
                new Siparis(1000, 2001, 31, 200),
                new Siparis(1000, 2002, 22, 150.86),
                new Siparis(1000, 2003, 41, 250),
                new Siparis(1000, 2004, 55, 244),
                new Siparis(1001, 2001, 88, 44.531),
                new Siparis(1001, 2002, 121, 88.11),
                new Siparis(1001, 2004, 74, 211),
                new Siparis(1001, 2002, 14, 88.11),
                new Siparis(1002, 2003, 2, 12.1),
                new Siparis(1002, 2004, 3, 22.3),
                new Siparis(1002, 2003, 8, 12.1),
                new Siparis(1002, 2002, 16, 94),
                new Siparis(1002, 2005, 9, 44.1),
                new Siparis(1002, 2006, 19, 90)
        );

        /**
         * Burada Do-While d�ng�s� ile daha g�zel bir se�im ekran� yaratmak istedim.
         */
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n****************      Project Abas App Ho� Geldiniz      ******************");
            System.out.println("L�tfen Bir Se�im Yap�n�z...\n");
            System.out.println("1. �� sipari�teki mallar�n toplam tutar�.");
            System.out.println("2. �� sipari�teki b�t�n mallar�n ortalama fiyat�.");
            System.out.println("3. �� sipari�teki b�t�n mallar�n tek tek mal bazl� ortalama fiyat�.");
            System.out.println("4. Tek tek mal bazl�, mallar�n hangi sipari�lerde ka� adet oldu�unun ��kt�s�.");
            System.out.println("5. �IKI�!");
            System.out.println("******************************************************************************");

            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    double toplamTutar = siparisListesi.stream()
                            .mapToDouble(siparis -> siparis.getMiktar() * siparis.getBirimFiyat())
                            .sum();
                    System.out.printf("�� sipari�teki mallar�n toplam tutar�: %.2f TL%n" , toplamTutar);
                    break;
                case 2:
                    double toplamFiyat = siparisListesi.stream()
                            .mapToDouble(Siparis::getBirimFiyat)
                            .sum();
                    double ortalamaFiyat = toplamFiyat / siparisListesi.size();
                    System.out.printf("�� sipari�teki b�t�n mallar�n ortalama fiyat�: %.2f TL%n", ortalamaFiyat );
                    break;
                case 3:
                    Map<Integer, List<Siparis>> malBazliGruplar = siparisListesi.stream()
                            .collect(Collectors.groupingBy(Siparis::getMalNo));
                    malBazliGruplar.forEach((malNo, siparisler) -> {
                        double toplamFiyat1 = siparisler.stream()
                                .mapToDouble(Siparis::getBirimFiyat)
                                .sum();
                        double ortalamaFiyat1 = toplamFiyat1 / siparisler.size();
                        System.out.printf("Mal No %d'nin ortalama fiyat�: %.2f TL%n", malNo, ortalamaFiyat1 );
                    });
                    break;
                case 4:
                    Map<Integer, Map<Integer, Integer>> malBazliSiparisler = siparisListesi.stream()
                            .collect(Collectors.groupingBy(
                                    Siparis::getMalNo,
                                    Collectors.groupingBy(
                                            Siparis::getSiparisNo,
                                            Collectors.summingInt(Siparis::getMiktar)
                                    )
                            ));
                    malBazliSiparisler.forEach((malNo, siparisler) -> {
                        System.out.printf("Mal No %d:%n", malNo);
                        siparisler.forEach((siparisNo, miktar) -> {
                            System.out.printf("  Sipari� No %d: %d adet%n", siparisNo, miktar);
                        });
                    });
                    break;
                case 5:
                    System.out.println("��k�� yap�l�yor...");
                    break;
                default:
                    System.out.println("Ge�ersiz se�im! , l�tfen 1-5 aras�nda bir say� ile tekrar deneyin.");
            }
        } while (secim != 5);

        scanner.close();
    }
}

