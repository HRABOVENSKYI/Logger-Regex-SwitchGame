package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part1 {

    public static final Logger logger = Logger.getLogger("MyLogger");

    static {
        try {
            FileHandler fileHandler = new FileHandler("App.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(convert(readFile("part1.txt")));
    }

    public static String convert(String input) {
        String output = input;
        Pattern pattern = Pattern.compile("\\w{4,}");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String word = matcher.group();
            String newWord = word.substring(2);
            output = output.replace(word, newWord);
        }
        return output;
    }

    public static String readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            logger.log(Level.INFO, e.getMessage(), e);
        }
        return null;
    }
}
