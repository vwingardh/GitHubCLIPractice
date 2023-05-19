package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String commandLineArgument = args[0];
        String jsonStream = getInformation();
        printJSON(commandLineArgument, jsonStream);
    }

    public static String getInformation() throws IOException {
        JSONObject json = new JSONObject(); // Create a JSON object
        Scanner scan = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter your first name: ");
        String userFirstName = scan.nextLine();  // Read user input
        json.put("first_name", userFirstName);

        System.out.println("Enter your last name: ");
        String userLastName = scan.nextLine();
        json.put("last_name", userLastName);

        System.out.println("Enter your age: ");
        String userAge = scan.nextLine();
        json.put("age", userAge);

        scan.close(); // Close scanner

        String jsonString = json.toString();

        final String ABSOLUTE_JSON_FILE_PATH = "/Users/vanessa/salt-labs/githubCommand/src/main/resources/personData.json";
        Path path = Path.of(ABSOLUTE_JSON_FILE_PATH);

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        OutputStream bufferedWriter = Files.newOutputStream(path);
        bufferedWriter.write(jsonString.getBytes());
        bufferedWriter.flush();
        bufferedWriter.close();

        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        return jsonString; // return JSON string to main
    }

    public static void printJSON(String command, String jsonStream) {
        System.out.println(command);
        System.out.println(jsonStream);
        if (command == "print") {
            System.out.println(jsonStream);
        }
    }
}