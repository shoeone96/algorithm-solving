package org.example.string;


public class leet_125 {
    public static void main(String[] args) {
        System.out.println(leet_125.isPalindrome("Marge, let's \"[went].\" I await {news} telegram."));
    }

    public static boolean isPalindrome(String input) {
        boolean answer = true;
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                input = input.replace(String.valueOf(input.charAt(i)), "");
                i--;
            }
            if (input.length() == i - 1) break;
        }
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return answer;
    }
}
