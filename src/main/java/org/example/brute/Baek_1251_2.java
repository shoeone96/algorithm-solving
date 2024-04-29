package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;;

public class Baek_1251_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 2; i < word.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder first = new StringBuilder(word.substring(0, j));
                StringBuilder second = new StringBuilder(word.substring(j, i));
                StringBuilder third = new StringBuilder(word.substring(i));
                StringBuilder sb = new StringBuilder();
                sb.append(first.reverse()).append(second.reverse()).append(third.reverse());
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

}
