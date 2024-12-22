package com.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CobolFileProcessor {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Vineesha\\OneDrive\\Desktop\\cobol.txt"; // Path to your file
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            List<String> updatedLines = lines.stream()
                .map(line -> line.replace("case of section copy variable", "EVALUATE variable IN copy"))
                .map(line -> line.replace("case 1 \"i am case1\"", "When 1 \"i am case1\""))
                .map(line -> line.replace("case 2 \"i am case2\"", "When 2 \"i am case2\""))
                .map(line -> line.replace("case \"empty\" \"i am empty\"", "When \"empty\" \"i am empty\""))
                .collect(Collectors.toList());

            updatedLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
