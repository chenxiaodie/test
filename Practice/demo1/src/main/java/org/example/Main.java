package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int sum = 0;
        while (sum <= 200){
            int temp = scanner.nextInt();
            arrList.add(temp);
            sum += temp;
        }

        System.out.println("Hello world!" + arrList);
    }
}