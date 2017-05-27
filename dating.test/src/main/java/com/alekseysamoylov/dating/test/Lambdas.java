package com.alekseysamoylov.dating.test;

/**
 * Created by alekseysamoylov on 5/20/17.
 */
public class Lambdas {

    static int b;

    int c;

    public static void main(String[] args) {
        final String a = "sdaf";
        Lambdas aaa = new Lambdas();
        aaa.c = 5;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                aaa.c = 6;
            }
        };
    }
}
