package com.zhijiang.test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        final int threadCount = 100;

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        Runnable r = () -> {
            Calculator calculator = doCalc();
            int result = calculator.calc();
            System.out.println("result is :" + result);
            countDownLatch.countDown();
        };

        for (int i = 0; i < threadCount; i++){
            new Thread(r).start();
        }

        countDownLatch.await();
    }

    public static Calculator doCalc() {
        Random random = new Random();

        int index = random.nextInt(1000);
        final int i = index;
        CurrentIndex.remove();
        CurrentIndex.set(i);

        return new Calculator() {
            @Override
            int calc() {
                int temp_i = CurrentIndex.get();

                if (temp_i != i) {
                    System.out.println("temp_i not equals i: " + temp_i + i);
                } else {
                    System.out.println("i : " + i);
                }
                return i * i;
            }
        };
    }
}
