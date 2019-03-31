package com.daniel.sort;

public class InsertionSort {

   public static void sort(Comparable[] a) {
      int N = a.length;
      for (int i = 1; i < N; i++) {
         for (int j = i; j > 0 && less(a[j], a[j-1]); j -- ) {
//            if (less(a[j], a[j-1]))
            exch(a, j, j-1);
         }
      }
   }

   public static void sortOptimize(Comparable[] a) {
      int N = a.length;
      for (int i = 1; i < N; i++) {
         Comparable e = a[i];
         int j;
         for (j = i; j > 0 && less(e, a[j-1]); j--)
            a[j] = a[j-1];
         a[j] = e;
      }
   }

   private static boolean less(Comparable v, Comparable w) {
      return v.compareTo(w) < 0;
   }

   private static void exch(Comparable[] a, int i, int j) {
      Comparable t = a[i];
      a[i] = a[j];
      a[j] = t;
   }

   private static void show(Comparable[] a) {
      for (int i = 0; i < a.length; i++)
         System.out.println(a[i] + " ");
      System.out.println();
   }

   public static boolean isSorted(Comparable[] a) {
      for (int i = 1; i < a.length; i ++) {
         if (less(a[i], a[i-1]))
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      String[] a = new String[]{"c", "a", "z", "f", "b", "e", "d", "n", "m"};
      sort(a);
      assert isSorted(a);
      System.out.println(isSorted(a));
      show(a);
      String[] b = new String[]{"c", "a", "z", "f", "b", "e", "d", "n", "m"};
      sort(b);
      assert isSorted(b);
      System.out.println(isSorted(b));
      show(b);
   }
}
