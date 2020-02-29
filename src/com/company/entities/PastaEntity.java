package com.company.entities;

import com.company.MakeVege;
import com.company.enums.IsVege;
import com.company.enums.Pasta;

public class PastaEntity extends ProductEntity implements MakeVege {
    private boolean addCheese;
    private Pasta pasta;
    private IsVege isVege = IsVege.NIE;

    //public ProductEntity(String prodName, String prodDesc, int prodPrice, int prodCal)
    public PastaEntity(String prodName, String prodDesc, int prodPrice, int prodCal, boolean addCheese, String pasta) {
        super(prodName, prodDesc, prodPrice, prodCal);
        this.addCheese = addCheese;
        this.pasta = Pasta.valueOf(pasta);
    }

    public boolean getAddCheese() { return addCheese; }
    public void setAddCheese(boolean addCheese) { this.addCheese = addCheese; }
    public Pasta getPasta() { return pasta; }
    public void setPasta(Pasta pasta) { this.pasta = pasta; }
    public IsVege getIsVege() {return isVege;}
    public void setIsVege(IsVege isVege) {this.isVege = isVege;}

    @Override
    public String toString() {
        if (this.isVege == IsVege.NIE){
            if (this.getProdMark() == 0) {
                if (this.getAddCheese()){
                    return super.toString() + ". Makaron: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta + ". Zawieram ser!.";
                }
                else{
                    return super.toString() + ". Makaron: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta +'.';
                }
            }
            else {
                if (this.getAddCheese()){
                    return super.toString() + ". Makaron: " + this.getProdName() + ". Ocena: " + this.getProdMark() +". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta + ". Zawieram ser!.";
                }
                else{
                    return super.toString() + ". Makaron: " + this.getProdName() + ". Ocena: " + this.getProdMark() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta +'.';
                }
            }
        }
        else {
            if (this.getProdMark() == 0) {
                if (this.getAddCheese()){
                    return super.toString() + ". Vege Makaron: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta + ". Zawieram ser!.";
                }
                else{
                    return super.toString() + ". Vege Makaron: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta +'.';
                }
            }
            else {
                if (this.getAddCheese()){
                    return super.toString() + ". Vege Makaron: " + this.getProdName() + ". Ocena: " + this.getProdMark() +". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta + ". Zawieram ser!.";
                }
                else{
                    return super.toString() + ". Vege Makaron: " + this.getProdName() + ". Ocena: " + this.getProdMark() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj makaronu: " + pasta +'.';
                }
            }
        }
    }

    @Override
    public void makeHealthy() {
        this.setProdCal((int)(this.getProdCal()*0.8));
    }

    @Override
    public void makeVege() {
        this.setIsVege(IsVege.TAK);
        this.setProdPrice(this.getProdPrice()+1);
        this.setProdDesc(this.getProdDesc() + " w calosci przygotowane ze skladnikow (zamiennikow) vege");
    }
}
