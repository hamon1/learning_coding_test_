import java.io.*;
import java.util.*;

public class quicksort {
    public static void main(String[] args) throws IOException {
        int[] a = { 10, 9, 8, 7, 4, 5, 6, 3, 2, 1};

        quickSort(a, 0, a.length - 1);

        for (int i = 0; i< a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    static void quickSort(int[] a, int s, int e) {
        if (s < e) {
            int pivot = parition(a, s, e);

            quickSort(a, s, pivot - 1);
            quickSort(a, pivot + 1, e);
        }
    }

    static int parition(int[] a, int s, int e) {
        if (e - s == 1) {
            if (a[s] > a[e]) swap(a, s, e);
            return e;
        }

        int m = (s + e) / 2;
        swap(a, s, m);
        int pivot = a[s];
        int i = s + 1;
        int j = e;

        while (i <= j) {
            while (j >= s + 1 && a[j] >= pivot) j--;
            while (i <= e && a[i] <= pivot) i++;

            if (i <= j) {
                swap(a, i++, j--);
            }
        }
        // swap(a, s, j);
        a[s] = a[j];
        a[j] = pivot;
        return j;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
