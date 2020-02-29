package com.company;


import java.util.ArrayList;

import com.company.entities.BurgerEntity;
import com.company.entities.CheeseBurgerEntity;
import com.company.entities.PastaEntity;
import com.company.entities.ProductEntity;
import java.util.*;

public class DataList{
    //pole statyczne odpowiedzialne za ostatnie wykorzystane ID
    static int lastID = 0;

    //w liscie beda przechowywane wszystkie dania z karty dan
    private static ArrayList<ProductEntity> productEntities = new ArrayList<>();

    //zwraca wszystkie produkty z karty dan
    public static ArrayList<ProductEntity> getProductEntities() {return productEntities;}
    public static void setProductEntities(ArrayList<ProductEntity> productEntities) {DataList.productEntities = productEntities;}
    public static void addProductEntity(ProductEntity productEntity) {DataList.productEntities.add(productEntity);}
    public static void removeProductEntity(ProductEntity productEntity) {DataList.productEntities.remove(productEntity);}
    public static int getLastID() {
        if (productEntities.size() != 0) {
            int id = lastID + 1;
            lastID = productEntities.get(productEntities.size() - 1).getProdID() + 1;
            return id;
        }
        else{
            return lastID;
        }
    }
    public static void makeNewID() {
        int ID = 0;
        for (ProductEntity p : productEntities) {
            p.setProdID(ID);
            ID++;
        }
    }

    public static void showDataList() {
        if (productEntities.size() == 0){
            System.out.println("We have no porducts in DataList, sorry.\n");
        } else {
            for (ProductEntity p : productEntities){
                System.out.println(p);
            }
        }
    }

    public static void removeProductEntityID(int ID) {
        productEntities.remove(ID);
        makeNewID();
        lastID = lastID - 1;
    }

    public static void showMeClass(String tmp_class){
        boolean tmp = true;
        for (ProductEntity p : productEntities){
            if(p.getClass().getSimpleName().equals(tmp_class)){
                System.out.println(p);
                tmp = false;
            }
        }
        if(tmp){System.out.println("No products in this class.");}
    }

    public static ArrayList<BurgerEntity> getListBurger(){
        ArrayList<BurgerEntity> listBurger = new ArrayList<>();
        for (ProductEntity p : productEntities){
            if (p.getClass().getSimpleName().equals("BurgerEntity")){
                listBurger.add((BurgerEntity) p);
            }
        }
        return listBurger;
    }

    public static ArrayList<CheeseBurgerEntity> getListCheeseBurger(){
        ArrayList<CheeseBurgerEntity> listChBurger = new ArrayList<>();
        for (ProductEntity p : productEntities){
            if (p.getClass().getSimpleName().equals("CheeseBurgerEntity")){
                listChBurger.add((CheeseBurgerEntity) p);
            }
        }
        return listChBurger;
    }

    public static ArrayList<PastaEntity> getListPasta(){
        ArrayList<PastaEntity> listPasta = new ArrayList<>();
        for (ProductEntity p : productEntities){
            if (p.getClass().getSimpleName().equals("PastaEntity")){
                listPasta.add((PastaEntity) p);
            }
        }
        return listPasta;
    }

    public static void showMeProductWithChar(String tmp_str){
        boolean tmp = true;
        tmp_str = tmp_str.toLowerCase();
        for (ProductEntity p : productEntities){
            String tmp_str1 = p.getProdName().toLowerCase();
            if(tmp_str1.contains(tmp_str)){
                System.out.println(p);
                tmp = false;
            }
        }
        if(tmp){System.out.println("No products with this char.");}
    }
}
