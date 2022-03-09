package com.sj;

import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        String input = input();
        int totalWords = countWords(input);
        System.out.println("total number of words are - "+ totalWords);
    }

    private static int countWords(String input) {
        String [] s1 = input.split("\\s+");
        return s1.length;
    }

    private static String input() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input a sentence or word");
        return s1.nextLine();
    }
}
