package org.example.string;

public class leet_344 {
    public static void main(String[] args) {

    }
    static char temp;
public void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2; i++) {
        temp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length -1 - i] = temp;
    }
}
}
