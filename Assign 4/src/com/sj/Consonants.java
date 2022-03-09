package com.sj;

import java.util.Scanner;

public class Consonants {
    public static void main(String[] args) {
        String input = input();
        countAndReplaceCons(input);
    }

    private static void countAndReplaceCons(String input) {
        StringBuilder revisedInput = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                revisedInput.append(input.charAt(i));
            } else {
                if (input.charAt(i) != ' ') {
                    revisedInput.append('*');
                    count = count + 1;
                }
            }
        }
        System.out.println("total number of consonants are - " + count);
        System.out.println("the new String is " + revisedInput);
    }

    private static String input() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input a sentence or word");
        return s1.nextLine();
    }

}
