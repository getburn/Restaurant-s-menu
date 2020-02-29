package com.company.entities;

public class CheeseBurgerEntity extends BurgerEntity {
    private boolean cheese;

    //public BurgerEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String dough, String egzAdd)
    public CheeseBurgerEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String dough, String egzAdd){
        super(prodName, prodDesc, prodPrice, prodCal, dough, egzAdd);
        this.cheese = false;
    }

    public boolean getCheese() {return cheese;}
    public void setCheese(boolean cheese) {
        if (!cheese) {
            System.out.println("Skoro nie chcesz sera, zamow burgera!");
        } else {
            this.cheese = cheese;
        }
    }

    //dietetyczny ser jest slaby, dlatego nawet w wersji "zdrowej" pozostaje wciaz tym samym serem
    @Override
    public void makeHealthy() {
        this.setProdCal((int)(this.getProdCal()*0.6));
    }

    @Override
    public String toString() {
        return super.toString() + " Zawieram ser!" + '\'';
    }

    @Override
    public void makeVege() {
        super.makeVege();
        //vege ser jest drogi :(
        this.setProdPrice(this.getProdPrice()+3);
    }
}
