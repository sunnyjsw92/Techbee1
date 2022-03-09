package com.sj;

import java.util.Scanner;

public class LastLetterCount {
    public static void main(String[] args) {
        String input = input();
        countWordsAndPrint(input);
    }

    private static void countWordsAndPrint(String input) {
        String[] input1 = input.split("\\s+");
        int totalCount = 0;
        int scounter = -1;
        int ycounter = -1;

        for (int i = input1.length-1; i >= 0; i--) {
            if (input1[i].endsWith("s")) {
                totalCount = totalCount + 1;
                scounter = i;
            }
            else if (input1[i].endsWith("y")){
                totalCount = totalCount+1;
                ycounter = i;
            }
            else continue;
        }
        System.out.println("total number of words ending with s and y area - "+ totalCount);

        if(scounter >= 0 && ycounter >= 0) {
            String s1 = input1[scounter];
            String s2 = input1[ycounter];
            input1[scounter]=s2;
            input1[ycounter]=s1;
        }
        System.out.println("the new sentence is - ");
        for (int j=0; j< input1.length; j++){
            System.out.print(input1[j]+ " ");
        }
    }

    private static String input() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input a sentence or word");
        return s1.nextLine();
    }
}
