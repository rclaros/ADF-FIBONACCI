package com.rclaros.algoritmo;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author RCLAROS
 */
public class Fibonacci {

    public static void main(String[] args) {
        long N = 80;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i <= N; i++) {
            try {
                System.out.println(i + " => " + recursive(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("Time elapsed: %d seconds", stopwatch.elapsed(TimeUnit.SECONDS)) + "\n");
    }

    public static long recursive(int n) {
        long[] list = new long[3];
        list[0] = 1;
        return recursive(n, list);
    }

    public static long recursive(int n, long[] list) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        } else {
            list[2] = list[1] + list[0];
            list[1] = list[0];
            list[0] = list[2];
            recursive(n - 1, list);
            return list[0] + list[1];
        }
    }
}
