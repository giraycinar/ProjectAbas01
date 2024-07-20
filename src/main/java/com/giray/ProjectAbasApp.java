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
         * Burada Do-While döngüsü ile daha güzel bir seçim ekraný yaratmak istedim.
         */
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n****************      Project Abas App Hoþ Geldiniz      ******************");
            System.out.println("Lütfen Bir Seçim Yapýnýz...\n");
            System.out.println("1. Üç sipariþteki mallarýn toplam tutarý.");
            System.out.println("2. Üç sipariþteki bütün mallarýn ortalama fiyatý.");
            System.out.println("3. Üç sipariþteki bütün mallarýn tek tek mal bazlý ortalama fiyatý.");
            System.out.println("4. Tek tek mal bazlý, mallarýn hangi sipariþlerde kaç adet olduðunun çýktýsý.");
            System.out.println("5. ÇIKIÞ!");
            System.out.println("******************************************************************************");

            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    double toplamTutar = siparisListesi.stream()
                            .mapToDouble(siparis -> siparis.getMiktar() * siparis.getBirimFiyat())
                            .sum();
                    System.out.printf("Üç sipariþteki mallarýn toplam tutarý: %.2f TL%n" , toplamTutar);
                    break;
                case 2:
                    double toplamFiyat = siparisListesi.stream()
                            .mapToDouble(Siparis::getBirimFiyat)
                            .sum();
                    double ortalamaFiyat = toplamFiyat / siparisListesi.size();
                    System.out.printf("Üç sipariþteki bütün mallarýn ortalama fiyatý: %.2f TL%n", ortalamaFiyat );
                    break;
                case 3:
                    Map<Integer, List<Siparis>> malBazliGruplar = siparisListesi.stream()
                            .collect(Collectors.groupingBy(Siparis::getMalNo));
                    malBazliGruplar.forEach((malNo, siparisler) -> {
                        double toplamFiyat1 = siparisler.stream()
                                .mapToDouble(Siparis::getBirimFiyat)
                                .sum();
                        double ortalamaFiyat1 = toplamFiyat1 / siparisler.size();
                        System.out.printf("Mal No %d'nin ortalama fiyatý: %.2f TL%n", malNo, ortalamaFiyat1 );
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
                            System.out.printf("  Sipariþ No %d: %d adet%n", siparisNo, miktar);
                        });
                    });
                    break;
                case 5:
                    System.out.println("Çýkýþ yapýlýyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! , lütfen 1-5 arasýnda bir sayý ile tekrar deneyin.");
            }
        } while (secim != 5);

        scanner.close();
    }
}

