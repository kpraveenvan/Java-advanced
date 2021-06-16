package com.praveen.streams.predicate.appleexample;

public class WeightPrintApplePredicate implements ApplePrintPredicate{

    @Override
    public String printApple(Apple apple) {
        return "Weight of Apple is " + apple.getWeight();
    }
}
