package com.company.entities;

import com.company.enums.Chips;

public class ChipsEntity extends ProductEntity{
    private Chips chips;
    private int salt = 2;

    //public ProductEntity(String prodName, String prodDesc, int prodPrice, int prodCal)
    public ChipsEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String chips) {
        super(prodName, prodDesc, prodPrice, prodCal);
        this.chips = Chips.valueOf(chips);
    }

    public Chips getChips(){return this.chips;}
    public void setChips(Chips chips) {this.chips = chips;}
    public int getSalt(){return this.salt;}
    public void setSalt(int salt){this.salt = salt;}

    //zmienjszenie kalorycznosci frytek jest trudne, ale sie da! (O 20%)
    @Override
    public void makeHealthy() {
        this.setProdCal((int)(this.getProdCal()*0.8));
    }

    @Override
    public String toString() {
        if(this.getProdMark() == 0){
            return super.toString() + ". Frytki: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Wykorzystano: " + chips + ". Dodatkowo level posolenia: " + salt + ". ";

        } else {
            return super.toString() + ". Frytki: " + this.getProdName() + ". Ocena: " + this.getProdMark() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Wykorzystano: " + chips + ". Dodatkowo level posolenia: " + salt + ". ";
        }
    }
}
