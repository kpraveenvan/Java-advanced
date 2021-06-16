package com.praveen.streams.predicate.appleexample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    List<Apple> inventory =  new ArrayList<>();

    private void populateInventory() {
        Apple apple1 = new Apple(20.0, "GREEN");
        Apple apple2 = new Apple(25.0, "RED");
        Apple apple3 = new Apple(26.0, "GREEN");
        Apple apple4 = new Apple(10.0, "RED");
        Apple apple5 = new Apple(15.0, "GREEN");
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);
    }

    public List<Apple> filterApples(Predicate<Apple> applePredicate) {

        List<Apple> appleList = new ArrayList<>();
        for(Apple apple : inventory) {
            if(applePredicate.test(apple)) {
                System.out.println("Apple passed the predicate with weight " + apple.getWeight() + " with color " + apple.getColor());
                appleList.add(apple);
            }
        }
        return appleList;
    }

    private class Apple {
        Double weight;
        String color;

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Apple(Double weight, String color) {
            this.weight = weight;
            this.color = color;
        }
    }

    public static void main(String[] args) {
       PredicateExample predicateExample = new PredicateExample();
       predicateExample.populateInventory();
       Predicate<Apple> greenApple = apple -> apple.getColor().equals("GREEN");
       Predicate<Apple> redApple = apple -> apple.getColor().equals("RED");
       Predicate<Apple> heavyApple = apple -> apple.getWeight() > 20;
        System.out.println("Filtering Green Apples");
       predicateExample.filterApples(greenApple);
        System.out.println("Filtering Red Apples");
       predicateExample.filterApples(redApple);
        System.out.println("Filtering Heavy Apples");
       predicateExample.filterApples(heavyApple);

    }
}
