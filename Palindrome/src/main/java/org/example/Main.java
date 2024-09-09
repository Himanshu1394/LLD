package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Solution newSolution = new Solution();

        System.out.printf("Insert a String");
        String s = scanner.nextLine();

        if(newSolution.isPalindrome(s)) {
            System.out.println("Palindrome");
            return;
        }

        System.out.println("Not a Palindrome");

    }
}