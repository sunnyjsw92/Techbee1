package com.sj;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String input = input();
        Boolean check = iPalindrome(input);
        System.out.println("Is - " + input + " - a Palindrome? - " + check);
    }

    private static Boolean iPalindrome(String input) {
        String revisedinput = input.replaceAll("\\s+", "");
        StringBuilder reverseInput = new StringBuilder();
        reverseInput.append(revisedinput);
        reverseInput.reverse();
        return reverseInput.toString().equals(revisedinput);

    }

    private static String input() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input a sentence or word");
        return s1.nextLine();
    }
}
