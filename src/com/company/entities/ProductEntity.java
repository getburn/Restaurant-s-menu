package com.company.entities;

import com.company.DataList;

public abstract class ProductEntity {

    static final int maksStar = 5;
    private int prodID; //id nadawane z bazy danych DataList
    private String prodName; //nazwa produktu
    private int prodMark = 0;//ocena produktu, ocenianie dania przez klientow
    private int numMark = 0;
    private int sumMark = 0;
    private String prodDesc; //opis produktu
    private int prodPrice; //cena produktu
    private int prodCal = 0; //kalorycznosc produktu


    public ProductEntity(String prodName, String prodDesc, int prodPrice, int prodCal) {
        this.setProdID(DataList.getLastID());
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodCal = prodCal;
    }

    public int getProdCal() {return prodCal;}
    public void setProdCal(int prodCal) {this.prodCal = prodCal;}
    public int getProdID() {
        return prodID;
    }
    public void setProdID(Integer prodID) {
        this.prodID = prodID;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public String getProdDesc() {
        return prodDesc;
    }
    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }
    public int getProdPrice() {
        return prodPrice;
    }
    public void setProdPrice(int prodPrize) {
        this.prodPrice = prodPrice;
    }
    public abstract void makeHealthy();
    public int getProdMark() {
        return prodMark;
    }
    public void setProdMark(int prodMark) {
        this.prodMark = prodMark;
    }
    //oceniamy produkt za pomocą skali od 1 do maksStar
    public void addMark(int tmp) {
        if (tmp > 0 && tmp < maksStar) {
            this.numMark++;
            this.sumMark = this.sumMark + tmp;
            this.prodMark = (int) (this.sumMark / this.numMark);
            System.out.println("Nowa ocena dania to: " + this.prodMark + ".\n");
        } else {
            System.out.println("Niepowodzenie przy dodwanaiu oceny!\n");
        }
    }

    @Override
    public String toString() {
        return "ID: " + prodID;
    }

}
