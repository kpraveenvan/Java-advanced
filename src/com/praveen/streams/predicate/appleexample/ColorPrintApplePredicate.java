package com.praveen.streams.predicate.appleexample;

public class ColorPrintApplePredicate implements ApplePrintPredicate{

    @Override
    public String printApple(Apple apple) {
        return "Color of Apple is " + apple.getColor();
    }
}
