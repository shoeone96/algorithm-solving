package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_10825 {

    static List<Student> students;

    public static void main(String[] args) throws IOException{
        input();
        Collections.sort(students);
        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb.append(student.name).append("\n"));
        System.out.println(sb);
    }

    private static void input() throws IOException {
        students = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name, korean, english, math);
            students.add(student);
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(korean != o.korean){
                return -(this.korean - o.korean);
            }
            if(english != o.english){
                return this.english - o.english;
            }
            if(math != o.math){
                return -(this.math - o.math);
            }
            return this.name.compareTo(o.name);
        }
    }

}
