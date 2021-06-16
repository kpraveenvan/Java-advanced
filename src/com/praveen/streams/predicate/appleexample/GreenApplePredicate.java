package com.praveen.streams.predicate.appleexample;

public class GreenApplePredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("GREEN");
    }
}
