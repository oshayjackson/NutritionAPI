package com.api.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    public User() {
        interact();
    }
    
    private void interact() {
        NutritionAPI api = new NutritionAPI();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            do {
                System.out.print("Enter a search query (type 'end' to exit): ");
                input = reader.readLine().trim().toLowerCase();
                if (!input.equals("end")) {
                    try {
                        NutritionInfo nutritionInfo = api.fetchNutritionInfo(input);
                        if (nutritionInfo != null) {
                            System.out.println("Nutrition Information:\n" + nutritionInfo);
                        } else {
                            System.out.println("No nutrition information found for the given query.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } while (!input.equals("end"));
        } catch (IOException e) {
            System.out.println("An error occurred while reading input. Please try again.");
            interact();
        }
    }
}