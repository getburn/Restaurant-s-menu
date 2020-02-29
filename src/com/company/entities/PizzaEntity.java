package com.company.entities;

import com.company.enums.Dough;
import com.company.enums.IsVege;

public class PizzaEntity extends ProductEntity {
    private boolean doubleChesse;
    private Dough pizzaDough;

    //public ProductEntity(String prodName, String prodDesc, int prodPrice, int prodCal)
    public PizzaEntity(String prodName, String prodDesc, int prodPrice, int prodCal, boolean doubleChesse, String pizzaDough) {
        super(prodName, prodDesc, prodPrice, prodCal);
        this.doubleChesse = doubleChesse;
        this.pizzaDough = Dough.valueOf(pizzaDough);
    }

    public boolean getDoubleChesse() {
        return doubleChesse;
    }
    public void setDoubleChesse(boolean doubleChesse) {
        this.doubleChesse = doubleChesse;
    }
    public Dough getPizzaDough() {
        return pizzaDough;
    }
    public void setPizzaDough(Dough pizzaDough) {
        this.pizzaDough = pizzaDough;
    }

    @Override
    public String toString() {
        if (this.getProdMark() == 0) {
            if (this.getDoubleChesse()){
                return super.toString() + ". Pizza: " + this.getProdName() + ". Opis: " + this.getProdDesc() + " z podwojnym serem! Cena: " + this.getProdPrice() + ". Rodzaj spodu: " + pizzaDough + ".";
            }
            else{
                return super.toString() + ". Pizza: " + this.getProdName() + ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj spodu: " + pizzaDough + ".";
            }
        }
        else {
            if (this.getDoubleChesse()){
                return super.toString() + ". Pizza: " + this.getProdName() + ". Ocena:" + this.getProdMark() + ". Opis: " + this.getProdDesc() + " z podwojnym serem! Cena: " + this.getProdPrice() + ". Rodzaj spodu: " + pizzaDough + ".";
            }
            else{
                return super.toString() + ". Pizza: " + this.getProdName() + ". Ocena:" + this.getProdMark() +  ". Opis: " + this.getProdDesc() + ". Cena: " + this.getProdPrice() + ". Rodzaj spodu: " + pizzaDough + ".";
            }
        }
    }

    //zmienjszenie kalorycznosci pizzy jest trudne, ale sie da! (O 20%)
    @Override
    public void makeHealthy() {
        this.setProdCal((int)(this.getProdCal()*0.8));
    }
}
