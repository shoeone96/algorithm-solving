package org.example.dfs;

import java.util.*;
import java.io.*;

public class Baek_2644 {

    static int n, person_1, person_2, m;
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        input();
        solution(person_1, 0);
        System.out.println(answer);
    }

    private static void solution(int input, int count) {
        visited[input] = true;
        if(input == person_2){
            answer = count;
            return;
        }

        for(int i = 0; i < graph[input].size(); i++){
            if(!visited[graph[input].get(i)]){
                solution(graph[input].get(i), count+1);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        person_1 = Integer.parseInt(st.nextToken());
        person_2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for(int i = 0; i <graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

    }

}
