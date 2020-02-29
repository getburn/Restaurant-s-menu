package com.company;

import com.company.enums.*;

public class CatchEnum {
    public static boolean tryDough(String dough) {
        dough = dough.toUpperCase();
        int errorCounter = 0;
        for (Dough d : Dough.values()) {
            if (!(d.toString().equals(dough))) {
                errorCounter++;
            }
        }
        if (errorCounter == Dough.values().length) {
            return false;
        }
        return true;
    }

    public static boolean tryBase(String base) {
        base = base.toUpperCase();
        int errorCounter = 0;
        for (Base d : Base.values()) {
            if (!(d.toString().equals(base))) {
                errorCounter++;
            }
        }
        if (errorCounter == Base.values().length) {
            return false;
        }
        return true;
    }

    public static boolean tryChips(String chips) {
        chips = chips.toUpperCase();
        int errorCounter = 0;
        for (Chips d : Chips.values()) {
            if (!(d.toString().equals(chips))) {
                errorCounter++;
            }
        }
        if (errorCounter == Chips.values().length) {
            return false;
        }
        return true;
    }

    public static boolean tryEgzAdd(String egzAdd) {
        egzAdd = egzAdd.toUpperCase();
        int errorCounter = 0;
        for (EgzAdd d : EgzAdd.values()) {
            if (!(d.toString().equals(egzAdd))) {
                errorCounter++;
            }
        }
        if (errorCounter == EgzAdd.values().length) {
            return false;
        }
        return true;
    }

    public static boolean tryIsVege(String isVege) {
        isVege = isVege.toUpperCase();
        int errorCounter = 0;
        for (IsVege d : IsVege.values()) {
            if (!(d.toString().equals(isVege))) {
                errorCounter++;
            }
        }
        if (errorCounter == IsVege.values().length) {
            return false;
        }
        return true;
    }

    public static boolean tryPasta(String pasta) {
        pasta = pasta.toUpperCase();
        int errorCounter = 0;
        for (Pasta d : Pasta.values()) {
            if (!(d.toString().equals(pasta))) {
                errorCounter++;
            }
        }
        if (errorCounter == Pasta.values().length) {
            return false;
        }
        return true;
    }

}
