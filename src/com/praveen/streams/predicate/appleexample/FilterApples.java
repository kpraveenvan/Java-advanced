package com.praveen.streams.predicate.appleexample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

public class FilterApples {
    
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        
        List<Apple> filteredApples = new ArrayList<>();
        for(Apple apple : inventory) {
            if(applePredicate.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    public static List<Apple> filterApplesUsingPredicates(List<Apple> inventory, Predicate<Apple> applePredicate) {

        List<Apple> filteredApples = new ArrayList<>();
        for(Apple apple : inventory) {
            if(applePredicate.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
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

        List<Apple> greenApples = filterApples(inventory, new GreenApplePredicate());
        List<Apple> heavyApples = filterApples(inventory, new HeavyApplePredicate());
        List<Apple> redApplesUsingAnonymousInnerClasses = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("RED");
            }
        });
        List<Apple> redApplesUsingLambdas = filterApples(inventory, apple -> apple.getColor().equals("RED")); //Using lambdas
        List<Apple> redApplesUsingLambdasAndPredicate = filterApplesUsingPredicates(inventory, apple -> apple.getColor().equals("RED")); //Using lambdas and Predicate interface
        inventory.sort((o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight()));
        //(or)
        inventory.sort(Comparator.comparingDouble(Apple::getWeight));

        //Unrelated
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadNameFuture = executorService.submit(() -> Thread.currentThread().getName());
        try {
            System.out.println(threadNameFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    
}
