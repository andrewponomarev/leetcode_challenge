package practice;

import java.util.ArrayList;

public class Recur {

    public static void main(String[] args) {
        double[] arr = new double[2019];
        arr[0] = 2;
        arr[1] = 2019;
        int i = 2;
        while (i < 2018) {
            arr[i] = (arr[i-1] + 1) / arr[i-2];
            System.out.println(arr[i]);
            i++;
        }
        System.out.println(arr[2017]);
    }
}
