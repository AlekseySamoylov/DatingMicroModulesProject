package com.alekseysamoylov.dating.test;

import java.util.function.Function;

/**
 * Created by alekseysamoylov on 5/20/17.
 */
public class ComposeFunctions {

    public static void main(String[] args) {
        Function<Integer, Integer> f1 = (a) -> a + 1;
        Function<Integer, Integer> f2 = (a) -> a * 2;
        Function<Integer, Integer> andThen = f1.andThen(f2);
        Function<Integer, Integer> compose = f1.compose(f2);


    }
}
