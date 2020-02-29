package com.company.entities;

import com.company.enums.Base;

public class SoupEntity extends ProductEntity {
    private Base base;

    //public ProductEntity(String prodName, String prodDesc, int prodPrice, int prodCal)
    public SoupEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String base) {
        super(prodName, prodDesc, prodPrice, prodCal);
        this.base = Base.valueOf(base);
    }

    public Base getBase() {
        return base;
    }
    public void setBase(Base base) {
        this.base = base;
    }

    @Override
    public String toString() {
        if (this.getProdMark() == 0){
            return super.toString() + ". Zupa: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Na bazie: " + base + ".";
        }
        else {
            return super.toString() + ". Zupa: " + this.getProdName() + ". Ocena:" + this.getProdMark() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Na bazie: " + base + ".";
        }
    }

    //Zupe najlawtiej "odchudzic"
    @Override
    public void makeHealthy() {
        this.setProdCal((int)(this.getProdCal()*0.4));
    }
}
