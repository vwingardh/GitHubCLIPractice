package org.example;

import org.json.JSONObject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(getInformation());
    }

    public static String getInformation() {
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

        return json.toString(); // return JSON string to main
    }
}