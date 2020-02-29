package com.company;

import com.company.entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static DataList dataList = new DataList();

    public static void main(String[] args) {
        dataList.addProductEntity(new CheeseBurgerEntity("Klasyczny", "Z pomidorem, ogorkiem, salata i majonezem", 18, 450, "PSZENNE", "BEZ"));
        dataList.addProductEntity(new BurgerEntity("Klasyczny, ale z serem", "Z pomidorem, ogorkiem, salata i majonezem", 20, 500, "PSZENNE", "BEZ"));
        dataList.addProductEntity(new ChipsEntity("Klasyczne", "Frytki, jak frytki. Po prostu frytki", 12, 300, "ZIEMNIAKI"));
        dataList.addProductEntity(new PizzaEntity("Margarita", "Zwykla pizza.", 15, 650, true, "PSZENNE"));
        dataList.addProductEntity(new SoupEntity("Rosol", "Idealny ba wsztstko", 13, 380, "ROSOL"));
        dataList.addProductEntity(new PastaEntity("Z krewetkami", "Makaron ze smażonymi krewetkami i czosnkiem", 25, 320, false, "DURUM"));
        welcome();
        menu();
    }
    public static void welcome() {
        System.out.println("Hello Stranger!");
        System.out.println("Welcome in our restaurant");
        System.out.println("Eat fast and die due to PTC");
        for (int i = 0; i < 4; i++) {
            System.out.print("---------");
        }
    }

    public static void menu() {
        //String whatToDo;
        while(true){
            System.out.println(" ");
            System.out.println("Select please what do you want to do");
            System.out.println("0 - Show me list of added earlier products");
            System.out.println("1 - Add the product to database");
            System.out.println("2 - Delete product from database");
            System.out.println("3 - Show me list of products of the indicated type");
            System.out.println("4 - Show me products with a given char in product name");
            System.out.println("5 - Perform interface operations on all products");
            System.out.println("6 - Exit!");

            int wybor = tryMakeChoice();

            switch (wybor) {
                case 0:
                    dataList.showDataList();
                    break;
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    System.out.println("Whitch product do you want to delate?");
                    dataList.showDataList();
                    int tmp_choice = tryMakeChoice();
                    if (tmp_choice > 0 && tmp_choice < (dataList.lastID + 1)) {
                        DataList.removeProductEntityID(tmp_choice);
                        System.out.println("The product has been removed.");
                    } else {
                        System.out.println("We don't have products with this ID.");
                    }
                    break;
                case 3:
                    showAllClassProducts();
                    break;
                case 4:
                    showAllProductWithChar();
                    break;
                case 5:
                    System.out.println("Performing operations from the interface on all objects.");
                    System.out.println("Objects on which we perform operations:");
                    DataList.showMeClass("BurgerEntity");
                    DataList.showMeClass("CheeseBurgerEntity");
                    DataList.showMeClass("PastaEntity");
                    ArrayList<BurgerEntity> burgerEntities = DataList.getListBurger();
                    ArrayList<CheeseBurgerEntity> cheeseBurgerEntities = DataList.getListCheeseBurger();
                    ArrayList<PastaEntity> pastaEntities = DataList.getListPasta();
                    for (BurgerEntity b : burgerEntities){
                        b.makeVege();
                    }
                    for (CheeseBurgerEntity c : cheeseBurgerEntities){
                        c.makeVege();
                    }
                    for (PastaEntity p : pastaEntities){
                        p.makeVege();
                    }
                    System.out.println("Done!");
                    break;
                case 6:
                    System.out.println("Why do you leave me?");
                    System.exit(0);
                default:
                    System.out.println("Sorry, we don't have this option :(.");
                    break;
            }



        }
    }

    public static void showAllClassProducts() {
        while(true){
            System.out.println(" ");
            System.out.println("Select please what class products do you want to see");
            System.out.println("0 - Burger");
            System.out.println("1 - CheeseBurger");
            System.out.println("2 - Chips");
            System.out.println("3 - Pasta");
            System.out.println("4 - Pizza");
            System.out.println("5 - Soup");
            System.out.println("6 - Back to main menu!");

            int wybor = tryMakeChoice();

            switch (wybor) {
                case 0:
                    DataList.showMeClass("BurgerEntity");
                    break;
                case 1:
                    DataList.showMeClass("CheeseBurgerEntity");
                    break;
                case 2:
                    DataList.showMeClass("ChipsEntity");
                    break;
                case 3:
                    DataList.showMeClass("PastaEntity");
                    break;
                case 4:
                    DataList.showMeClass("PizzaEntity");
                    break;
                case 5:
                    DataList.showMeClass("SoupEntity");
                    break;
                case 6:
                    menu();
                default:
                    System.out.println("Sorry, we don't have this option :(.");
                    break;
            }
        }
    }

    public static void showAllProductWithChar() {
        while(true){
            System.out.println("Give char/string you looking for: ");
            String tmp = scan.nextLine();
            if(!tmp.isEmpty()){
                DataList.showMeProductWithChar(tmp);
                menu();
            }
            else{
                System.out.println("String is empty, please try again!");
            }
        }
    }

    public static int tryMakeChoice() {
        int tmp = 0;
        try {
            Scanner in = new Scanner(System.in);
            tmp = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid choice! Try again!");
            tryMakeChoice();
        }
        return tmp;
    }

    public static boolean tryMakeBoolean() {
        System.out.println("Yes or no?");
        String tmp = scan.nextLine();
        tmp = tmp.toUpperCase();
        if (tmp.equals("YES") || tmp.equals("Y")){
            return true;
        }
        if (tmp.equals("NO") || tmp.equals("N")){
            return false;
        }
        else {
            tryMakeBoolean();
            return false;
        }
    }

    public static void addNewProduct() {
        System.out.println(" ");
        System.out.println("Select please what do you want to add");
        System.out.println("0 - Burger");
        System.out.println("1 - CheeseBurger");
        System.out.println("2 - Chips");
        System.out.println("3 - Pasta");
        System.out.println("4 - Pizza");
        System.out.println("5 - Soup");
        System.out.println("6 - Back to main menu!");

        int wybor = tryMakeChoice();
        while(true){
            switch (wybor) {
                case 0:
                    //public BurgerEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String dough, String egzAdd)
                    System.out.println("Give product name: ");
                    String prodName = scan.nextLine();
                    System.out.println("Give product description: ");
                    String prodDesc = scan.nextLine();
                    System.out.println("Give product price:");
                    int prodPrice = tryMakeChoice();
                    System.out.println("Give product calories: ");
                    int prodCal = tryMakeChoice();
                    System.out.println("Give product dough: ");
                    String dough = scan.nextLine();
                    while(!CatchEnum.tryDough(dough)){
                        System.out.println("Try again!");
                        dough = scan.nextLine();
                    }
                    dough = dough.toUpperCase();
                    System.out.println("Give product egzotic add: ");
                    String egzAdd = scan.nextLine();
                    while(!CatchEnum.tryEgzAdd(egzAdd)){
                        System.out.println("Try again!");
                        egzAdd = scan.nextLine();
                    }
                    egzAdd = egzAdd.toUpperCase();
                    DataList.addProductEntity(new BurgerEntity(prodName, prodDesc, prodPrice, prodCal, dough, egzAdd));
                    System.out.println("Added!");
                    menu();
                    break;
                case 1:
                    //public CheeseBurgerEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String dough, String egzAdd)
                    System.out.println("Give product name: ");
                    prodName = scan.nextLine();
                    System.out.println("Give product description: ");
                    prodDesc = scan.nextLine();
                    System.out.println("Give product price:");
                    prodPrice = tryMakeChoice();
                    System.out.println("Give product calories: ");
                    prodCal = tryMakeChoice();
                    System.out.println("Give product dough: ");
                    dough = scan.nextLine();
                    while(!CatchEnum.tryDough(dough)){
                        System.out.println("Try again!");
                        dough = scan.nextLine();
                    }
                    dough = dough.toUpperCase();
                    System.out.println("Give product egzotic add: ");
                    egzAdd = scan.nextLine();
                    while(!CatchEnum.tryEgzAdd(egzAdd)){
                        System.out.println("Try again!");
                        egzAdd = scan.nextLine();
                    }
                    egzAdd = egzAdd.toUpperCase();
                    DataList.addProductEntity(new CheeseBurgerEntity(prodName, prodDesc, prodPrice, prodCal, dough, egzAdd));
                    System.out.println("Added!");
                    menu();
                    break;
                case 2:
                    //public ChipsEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String chips)
                    System.out.println("Give product name: ");
                    prodName = scan.nextLine();
                    System.out.println("Give product description: ");
                    prodDesc = scan.nextLine();
                    System.out.println("Give product price:");
                    prodPrice = tryMakeChoice();
                    System.out.println("Give product calories: ");
                    prodCal = tryMakeChoice();
                    System.out.println("Give product chips (ZIEMNIAKI, BATATY): ");
                    String chips = scan.nextLine();
                    while(!CatchEnum.tryChips(chips)){
                        System.out.println("Try again!");
                        chips = scan.nextLine();
                    }
                    chips = chips.toUpperCase();
                    DataList.addProductEntity(new ChipsEntity(prodName, prodDesc, prodPrice, prodCal, chips));
                    System.out.println("Added!");
                    menu();
                    break;
                case 3:
                    //public PastaEntity(String prodName, String prodDesc, int prodPrice, int prodCal, boolean addCheese, String pasta)
                    System.out.println("Give product name: ");
                    prodName = scan.nextLine();
                    System.out.println("Give product description: ");
                    prodDesc = scan.nextLine();
                    System.out.println("Give product price:");
                    prodPrice = tryMakeChoice();
                    System.out.println("Give product calories: ");
                    prodCal = tryMakeChoice();
                    boolean addCheese = tryMakeBoolean();
                    String pasta = scan.nextLine();
                    while(!CatchEnum.tryPasta(pasta)){
                        System.out.println("Try again!");
                        pasta = scan.nextLine();
                    }
                    pasta = pasta.toUpperCase();
                    DataList.addProductEntity(new PastaEntity(prodName, prodDesc, prodPrice, prodCal, addCheese, pasta));
                    System.out.println("Added!");
                    menu();
                    break;
                case 4:
                    // public PizzaEntity(String prodName, String prodDesc, int prodPrice, int prodCal, boolean doubleChesse, String pizzaDough)
                    System.out.println("Give product name: ");
                    prodName = scan.nextLine();
                    System.out.println("Give product description: ");
                    prodDesc = scan.nextLine();
                    System.out.println("Give product price:");
                    prodPrice = tryMakeChoice();
                    System.out.println("Give product calories: ");
                    prodCal = tryMakeChoice();
                    boolean doubleChesse = tryMakeBoolean();
                    System.out.println("Give product pizza dough: ");
                    String pizzaDough = scan.nextLine();
                    while(!CatchEnum.tryDough(pizzaDough)){
                        System.out.println("Try again!");
                        pizzaDough = scan.nextLine();
                    }
                    pizzaDough = pizzaDough.toUpperCase();
                    DataList.addProductEntity(new PizzaEntity(prodName, prodDesc, prodPrice, prodCal, doubleChesse, pizzaDough));
                    System.out.println("Added!");
                    menu();
                    break;
                case 5:
                    //public SoupEntity(String prodName, String prodDesc, int prodPrice, int prodCal, String base)
                    System.out.println("Give product name: ");
                    prodName = scan.nextLine();
                    System.out.println("Give product description: ");
                    prodDesc = scan.nextLine();
                    System.out.println("Give product price:");
                    prodPrice = tryMakeChoice();
                    System.out.println("Give product calories: ");
                    prodCal = tryMakeChoice();
                    System.out.println("Give product soup base: ");
                    String base = scan.nextLine();
                    while(!CatchEnum.tryBase(base)){
                        System.out.println("Try again!");
                        base = scan.nextLine();
                    }
                    base = base.toUpperCase();
                    DataList.addProductEntity(new SoupEntity(prodName, prodDesc, prodPrice, prodCal, base));
                    System.out.println("Added!");
                    menu();
                    break;
                case 6:
                    menu();
                    break;
                default:
                    System.out.println("Sorry, we don't have this option :(. Try again!");
                    break;
            }

        }

    }
}
