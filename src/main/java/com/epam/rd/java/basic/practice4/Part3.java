package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.rd.java.basic.practice4.Part1.readFile;

public class Part3 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String regChar = "\\b\\p{L}\\b";
        final String regInt = "(?<=\\s|^)\\d+(?=\\s|$)";
        final String regDouble = "\\b\\d+\\.\\d+\\b";
        final String regString = "\\b\\p{L}{2,}\\b";

        String input;
        String regex;

        while (true) {
            try {
                input = reader.readLine();
                if (input.equals("stop"))
                    break;
                switch (input) {
                    case "int":
                        regex = regInt;
                        break;
                    case "double":
                        regex = regDouble;
                        break;
                    case "char":
                        regex = regChar;
                        break;
                    case "String":
                        regex = regString;
                        break;
                    default:
                        regex = null;
                        break;
                }
                System.out.println(getElements(regex, "part3.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getElements(String regex, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        if (regex != null) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Objects.requireNonNull(readFile(fileName)));
            while (matcher.find()) {
                stringBuilder.append(matcher.group()).append(" ");
            }
        } else {
            stringBuilder.append("Incorrect input");
        }
        return stringBuilder.toString();
    }

}
