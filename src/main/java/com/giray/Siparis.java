package com.giray;


import lombok.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


class Siparis {
    private int siparisNo;
    private int malNo;
    private int miktar;
    private double birimFiyat;


    /** Burada Getter-Setter methodlar ve Constructorlar Kullan�lm�� olup farkl� bir yol izlemek istedi�im i�in
     * Lombok Annotationlar kullan�ld�m.
     * Dilersek altta yorum sat�r�na ald���m ��z�m�de yapabilirsiniz.
     *
     */



//    public Siparis(int siparisNo, int malNo, int miktar, double birimFiyat) {
//        this.siparisNo = siparisNo;
//        this.malNo = malNo;
//        this.miktar = miktar;
//        this.birimFiyat = birimFiyat;
//    }

//    public int getSiparisNo() {
//        return siparisNo;
//    }
//
//    public void setSiparisNo(int siparisNo) {
//        this.siparisNo = siparisNo;
//    }
//
//    public int getMalNo() {
//        return malNo;
//    }
//
//    public void setMalNo(int malNo) {
//        this.malNo = malNo;
//    }
//
//    public int getMiktar() {
//        return miktar;
//    }
//
//    public void setMiktar(int miktar) {
//        this.miktar = miktar;
//    }
//
//    public double getBirimFiyat() {
//        return birimFiyat;
//    }
//
//    public void setBirimFiyat(double birimFiyat) {
//        this.birimFiyat = birimFiyat;
//    }
}