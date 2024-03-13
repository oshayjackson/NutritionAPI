package com.api.app;

public class NutritionInfo {
    private int calories;
    private double servingSize;
    private double fatTotal;
    private double protein;
    private double sodium;
    private double cholesterol;
    private double carbohydratesTotal;
    private double fiber;
    private double sugar;
    
    public NutritionInfo(int calories, double servingSize, double fatTotal, double protein, double sodium,
                         double cholesterol, double carbohydratesTotal, double fiber, double sugar) {
        this.calories = calories;
        this.servingSize = servingSize;
        this.fatTotal = fatTotal;
        this.protein = protein;
        this.sodium = sodium;
        this.cholesterol = cholesterol;
        this.carbohydratesTotal = carbohydratesTotal;
        this.fiber = fiber;
        this.sugar = sugar;
    }
    
    // Getters and setters (or accessors and mutators) for each attribute
    public int getCalories() {
        return calories;
    }
    
    public void setCalories(int calories) {
        this.calories = calories;
    }
    
    public double getServingSize() {
        return servingSize;
    }
    
    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }
    
    public double getFatTotal() {
        return fatTotal;
    }
    
    public void setFatTotal(double fatTotal) {
        this.fatTotal = fatTotal;
    }
    
    public double getProtein() {
        return protein;
    }
    
    public void setProtein(double protein) {
        this.protein = protein;
    }
    
    public double getSodium() {
        return sodium;
    }
    
    public void setSodium(double sodium) {
        this.sodium = sodium;
    }
    
    public double getCholesterol() {
        return cholesterol;
    }
    
    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }
    
    public double getCarbohydratesTotal() {
        return carbohydratesTotal;
    }
    
    public void setCarbohydratesTotal(double carbohydratesTotal) {
        this.carbohydratesTotal = carbohydratesTotal;
    }
    
    public double getFiber() {
        return fiber;
    }
    
    public void setFiber(double fiber) {
        this.fiber = fiber;
    }
    
    public double getSugar() {
        return sugar;
    }
    
    public void setSugar(double sugar) {
        this.sugar = sugar;
    }
}