package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.epam.rd.java.basic.practice4.Part3.getElements;

public class Part6 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String cyrl = "(\\p{IsCyrillic}+)";
        final String latn = "([a-zA-Z]+)";

        String input;
        String regex;
        while (true) {
            try {
                input = reader.readLine();
                if (input.equals("stop"))
                    break;
                if (input.equalsIgnoreCase("cyrl")) {
                    regex = cyrl;
                    System.out.print("Cyrl: ");
                } else if (input.equalsIgnoreCase("latn")) {
                    regex = latn;
                    System.out.print("Latn: ");
                } else {
                    regex = null;
                    System.out.print("smth: ");
                }
                System.out.println(getElements(regex, "part6.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
