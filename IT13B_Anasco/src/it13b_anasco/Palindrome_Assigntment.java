/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it13b_anasco;

import java.util.Scanner;

public class Palindrome_Assigntment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter words:");
        String Name = in.nextLine();

        for (int x = Name.length() - 1; x >= 0; x--) {
            System.out.print(Name.charAt(x) + " ");
        }

        System.out.println();

    }
}
 
