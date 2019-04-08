package com.daniel.sort;


import com.google.common.base.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.TimeUnit;

public class SortCompare {

    public static double time(String alg, Comparable[] a) {

        Stopwatch timer = Stopwatch.createStarted();
        if(alg.equals("InsertionSort")) InsertionSort.sort(a);
        if(alg.equals("SelectionSort")) SelectionSort.sort(a);
        if(alg.equals("ShellSort")) ShellSort.sort(a);
        return timer.elapsed(TimeUnit.MILLISECONDS);
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // 使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        StdOut.printf("%s used %.1f MILLISECONDS\n", alg, total);
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf("For %.1f times faster than %s\n", t2/t1, alg2);
    }

}
