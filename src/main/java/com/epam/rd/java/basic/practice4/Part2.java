package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) {
        String fileName = "part2.txt";
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = getRandomNumber();
        }
        writeToFile(fileName, numbers);
        String[] numberStr = Objects.requireNonNull(readFile(fileName)).split(" ");
        for (int i = 0; i < numberStr.length; i++) {
            numbers[i] = Integer.parseInt(numberStr[i]);
        }
        String fileNameSorted = "part2_sorted.txt";
        writeToFile(fileNameSorted, bubbleSort(numbers));

        System.out.println("input ==> " + readFile(fileName) + "\noutput ==> " + readFile(fileNameSorted));
    }

    public static int[] bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }

    public static int getRandomNumber() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(50);
    }

    public static void writeToFile(String name, int[] input) {
        try (FileWriter myWriter = new FileWriter(name)) {
            for (int i = 0; i < input.length; i++) {
                myWriter.write(String.valueOf(input[i]));
                if (i != input.length - 1) {
                    myWriter.write(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String name) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
