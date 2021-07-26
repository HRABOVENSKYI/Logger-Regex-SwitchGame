package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Locale local;
        String input;
        while (true) {
            try {
                input = reader.readLine();
                if (input.equals("stop"))
                    break;
                Pattern pattern = Pattern.compile("(.+)\\s(.+)");
                Matcher matcher = pattern.matcher(input);
                matcher.find();
                String key = matcher.group(1);
                switch (matcher.group(2)) {
                    case "ru":
                        local = new Locale("ru");
                        break;
                    case "en":
                        local = new Locale("en");
                        break;
                    default:
                        local = null;
                        break;
                }
                ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", local);
                resourceBundle.getString("table");
                System.out.println(resourceBundle.getString(key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
