package com.example.bader.recihelp;

public class MainListModel {

    String title;
    String difficultyLevel;
    String time;
    String ingredients;
    String desc;
    String cuisine;


    public MainListModel(String title, String difficultyLevel, String time, String ingredients, String desc, String cuisine){
        this.title = title;
        this.difficultyLevel = difficultyLevel;
        this.time = time;
        this.ingredients = ingredients;
        this.desc = desc;
        this.cuisine = cuisine;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
