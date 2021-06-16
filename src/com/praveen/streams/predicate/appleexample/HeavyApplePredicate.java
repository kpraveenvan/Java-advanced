package com.praveen.streams.predicate.appleexample;

public class HeavyApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
