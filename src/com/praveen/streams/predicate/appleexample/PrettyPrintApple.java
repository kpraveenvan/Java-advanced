package com.praveen.streams.predicate.appleexample;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintApple {

    public static void printApples(List<Apple> inventory, ApplePrintPredicate applePrintPredicate) {

        for(Apple apple : inventory) {
            System.out.println(applePrintPredicate.printApple(apple));
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple1 = new Apple(200.0, "GREEN");
        Apple apple2 = new Apple(250.0, "RED");
        Apple apple3 = new Apple(260.0, "GREEN");
        Apple apple4 = new Apple(100.0, "RED");
        Apple apple5 = new Apple(150.0, "GREEN");
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);

        printApples(inventory, new WeightPrintApplePredicate());
        printApples(inventory, new ColorPrintApplePredicate());
    }
}
