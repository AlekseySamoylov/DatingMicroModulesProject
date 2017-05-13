package com.alekseysamoylov.dating.test;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer> {
    private List<Integer> testNumberList = new ArrayList<>();

    private ForkJoinTest() {
    }

    private ForkJoinTest(List<Integer> testNumberList) {
        this.testNumberList = testNumberList;
    }

    public static void main(String[] args) {
        ForkJoinTest forkJoinTest = new ForkJoinTest();
        forkJoinTest.fillList();
        long startTime = System.currentTimeMillis();
        forkJoinTest.computeDirectlySlow();
        System.out.println("Execute slow " + (System.currentTimeMillis() - startTime));
        forkJoinTest = new ForkJoinTest();
        forkJoinTest.fillList();
        startTime = System.currentTimeMillis();
        forkJoinTest.invoke();
        System.out.println("Execute fast " + (System.currentTimeMillis() - startTime));


    }


    private void fillList() {
        for (int i = 0; i < 100000; i++) {
            testNumberList.add(BigDecimal.valueOf(Math.random() * 1000).intValue());
        }
    }

    private void computeDirectly() {
        for (int i = 0; i < testNumberList.size(); i++) {
            System.out.println(testNumberList.get(i));
            testNumberList.set(i, 0);

        }
    }

    private void computeDirectlySlow() {
        for (int i = 0; i < testNumberList.size(); i++) {
            System.out.println(testNumberList.get(i));
            testNumberList.set(i, 0);
        }
    }

    @Override
    protected Integer compute() {
        int size = testNumberList.size();
        if (size < 10) {
            computeDirectly();
            return 0;
        } else {
            int subSize = size / 2 + 1;
            List<Integer> sublist1 = testNumberList.subList(0, subSize);
            ForkJoinTask forkJoinTask1 = new ForkJoinTest(sublist1);

            List<Integer> sublist2 = testNumberList.subList(subSize, size);
            ForkJoinTask forkJoinTask2 = new ForkJoinTest(sublist2);
            invokeAll(forkJoinTask1, forkJoinTask2);
            return 1;
        }

    }
}
