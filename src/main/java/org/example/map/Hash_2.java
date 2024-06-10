package org.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Hash_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String first = st.nextToken();
        st = new StringTokenizer(bf.readLine());
        String second = st.nextToken();
        Map<Character, Integer> firstWordMap = new HashMap<>();
        for (char ele : first.toCharArray()) {
            firstWordMap.put(ele, firstWordMap.getOrDefault(ele, 0) + 1);
        }
        Map<Character, Integer> secondWordMap = new HashMap<>();
        for (char ele : second.toCharArray()) {
            secondWordMap.put(ele, secondWordMap.getOrDefault(ele, 0) + 1);
        }

        for (char key : firstWordMap.keySet()) {
            if (!secondWordMap.containsKey(key)){
                System.out.println("NO");
                return;
            }
            if(firstWordMap.get(key) != secondWordMap.get(key)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
