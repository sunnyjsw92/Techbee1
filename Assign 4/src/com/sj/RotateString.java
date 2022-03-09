package com.sj;

import java.util.Scanner;

public class RotateString {
    static String input;
    static  int count;

    public static void main(String[] args) {
        input1();
        rotate(input,count);
    }

    private static void rotate(String input, int count) {
        char[] cinput = input.toCharArray();
        int length = cinput.length;
        while(count>0) {
            char x = cinput[0];
            for(int i=1; i<length;i++){
                cinput[i-1]=cinput[i];
            }
            cinput[length-1]=x;
            count = count-1;
        }
        System.out.println("the new word is ");
        for(int j=0; j< length; j++){
            System.out.print(cinput[j]);
        }
    }

    private static void input1() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input word");
        input = s1.nextLine();
        System.out.println("please enter count for rotation");
        count = s1.nextInt();
    }
}
