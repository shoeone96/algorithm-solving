package org.example.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14888 {

    static int N;
    static int[] numArr;
    static final int[] operators = new int[4];
    static int max, min;

    public static void main(String[] args) throws IOException {
        input();
        prod(1, numArr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void prod(int count, int result) {
        if (count == N) {
            if (result > max){
                max = result;
            }
            if(result < min){
                min = result;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) {
                continue;
            }
            int tempResult = result;
            if (i == 0) {
                result += numArr[count];
            }
            if (i == 1) {
                result -= numArr[count];
            }
            if (i == 2) {
                result *= numArr[count];
            }
            if (i == 3) {
                if (result < 0) {
                    result = -(-(result) / numArr[count]);
                } else {
                    result /= numArr[count];
                }
            }
            operators[i]--;
            prod(count + 1, result);
            operators[i]++;
            result = tempResult;
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        N = Integer.parseInt(st.nextToken());
        numArr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
    }

}
