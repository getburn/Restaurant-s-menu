package com.company.entities;

import com.company.MakeVege;
import com.company.enums.EgzAdd;
import com.company.enums.Dough;
import com.company.enums.IsVege;

public class BurgerEntity extends ProductEntity implements MakeVege {
    private Dough dough;
    private EgzAdd egzAdd;
    private IsVege isVege = IsVege.NIE;

    //public ProductEntity(String prodName, String prodDesc, int prodPrice)
    public BurgerEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String dough, String egzAdd) {
        super(prodName, prodDesc, prodPrice, prodCal);
        this.dough = Dough.valueOf(dough);
        this.egzAdd = EgzAdd.valueOf(egzAdd);
    }

    public Dough getDough() {return dough;}
    public void setDough(Dough dough) {this.dough = dough;}
    public EgzAdd getEgzAdd() {return egzAdd;}
    public void setEgzAdd(EgzAdd egzAdd) {this.egzAdd = egzAdd;}
    public IsVege getIsVege() {return isVege;}
    public void setIsVege(IsVege isVege) {this.isVege = isVege;}

    @Override
    public String toString() {
        if (this.isVege == IsVege.NIE){
            if (this.getProdMark() == 0) {
                return super.toString() + ". Burger: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Pieczywo: " + dough + ". Egoztyczny dodatek: " + egzAdd +'.';
            }
            else {
                return super.toString() + ". Burger: " + this.getProdName() + ". Ocena: " + this.getProdMark() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Pieczywo: " + dough + ". Egoztyczny dodatek: " + egzAdd +'.';

            }
        }
        else {
            if (this.getProdMark() == 0) {
                return super.toString() + ". Vege Burger: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Pieczywo: " + dough + ". Egoztyczny dodatek: " + egzAdd + '.';
            }
            else {
                return super.toString() + ". Vege Burger: " + this.getProdName() + ". Ocena: " + this.getProdMark() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Pieczywo: " + dough + ". Egoztyczny dodatek: " + egzAdd + '.';

            }
        }
    }

    //metoda zmniejsza kalorycznosc posilku o polowe
    @Override
    public void makeHealthy() {
        this.setProdCal((int)(this.getProdCal()*0.6));
    }

    @Override
    public void makeVege() {
        this.setIsVege(IsVege.TAK);
        this.setProdPrice(this.getProdPrice()+2);
        this.setProdDesc(this.getProdDesc() + " w calosci przygotowane ze skladnikow (zamiennikow) vege");
    }
}
