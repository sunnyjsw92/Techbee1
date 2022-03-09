package com.sj;

import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {
        String inputInfo = input();
        int noVowels = countVowels(inputInfo);
        System.out.println("total number of vowels in the input information - " + noVowels);
    }

    private static int countVowels(String inputInfo) {
        int count = 0;
        for (int i = 0; i < inputInfo.length(); i++) {
            char x = inputInfo.charAt(i);
            switch (x) {
                case 'a':
                    count = count + 1;
                    break;
                case 'e':
                    count = count + 1;
                    break;
                case 'i':
                    count = count + 1;
                    break;
                case 'o':
                    count = count + 1;
                    break;
                case 'u':
                    count = count + 1;
                    break;
            }
        }
        return count;
    }

    private static String input() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input a sentence or word");
        return s1.nextLine();
    }
}
