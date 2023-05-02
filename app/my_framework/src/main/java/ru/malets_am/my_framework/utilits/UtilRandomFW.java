package ru.malets_am.my_framework.utilits;

import java.util.Random;

public class UtilRandomFW {
    public static int getCasualNumber(int number){
        Random random = new Random();
        int casualNumber = random.nextInt(number);
        return casualNumber;
    }
}
