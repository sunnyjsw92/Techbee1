package com.sj;

import java.util.*;

public class TraverseString {
    public static void main(String[] args) {
        String input = input();
        traverse(input);
    }

    private static void traverse(String input) {
        Set<Character> s1 = new LinkedHashSet<>();
        for (int i=0; i<input.length(); i++){
            s1.add(input.charAt(i));
        }
        Iterator it = s1.iterator();
        System.out.println();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    private static String input() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("please input a sentence or word");
        return s1.nextLine();
    }
}
