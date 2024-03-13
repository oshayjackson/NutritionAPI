package com.api.app;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NutritionAPI {
    
    private static final String API_KEY = "JcB+TqcZr4AtvUDD7DMH5g==ujF81TyyYNexrTUh";
    private static final String API_URL = "https://api.calorieninjas.com/v1/nutrition?query=";
    private static final String HEADERS = "X-Api-Key";
    
    private final Gson gson;
    
    public NutritionAPI() {
        this.gson = new Gson();
    }
    
    public NutritionInfo fetchNutritionInfo(String query) {
        try {
            URL url = new URL(API_URL + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty(HEADERS, API_KEY);
            
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = responseReader.readLine()) != null) {
                        response.append(line);
                    }
                    
                    JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
                    JsonArray items = jsonResponse.getAsJsonArray("items");
                    
                    if (!items.isEmpty()) {
                        JsonObject item = items.get(0).getAsJsonObject();
                        return new NutritionInfo(
                                item.get("calories").getAsInt(),
                                item.get("serving_size_g").getAsDouble(),
                                item.get("fat_total_g").getAsDouble(),
                                item.get("protein_g").getAsDouble(),
                                item.get("sodium_mg").getAsDouble(),
                                item.get("cholesterol_mg").getAsDouble(),
                                item.get("carbohydrates_total_g").getAsDouble(),
                                item.get("fiber_g").getAsDouble(),
                                item.get("sugar_g").getAsDouble()
                        );
                    } else {
                        System.out.println("No items found for the given query.");
                    }
                }
            } else {
                System.out.println("Error: HTTP response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}