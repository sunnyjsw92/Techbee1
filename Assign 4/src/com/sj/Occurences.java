package com.sj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Occurences {
    public static void main(String[] args) {
        int[] input = new int[]{10, 10, 5, 12, 3, 5};
        countOccurences(input);

    }

    private static void countOccurences(int[] input) {
        Map<Integer, Integer> countTimes = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            if (countTimes.containsKey(input[i])) {
                countTimes.put(input[i], countTimes.get(input[i]) + 1);
            } else {
                countTimes.put(input[i], 1);
            }
        }
         Iterator it1 = countTimes.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry me = (Map.Entry) it1.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }

    }
}
