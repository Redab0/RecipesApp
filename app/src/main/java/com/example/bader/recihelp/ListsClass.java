package com.example.bader.recihelp;

import java.util.ArrayList;
import java.util.List;

public class ListsClass {

    private final static List<MainListModel> mainList = new ArrayList<>();
    private final static List<MainListModel> desertList = new ArrayList<>();
    private final static List<MainListModel> saladList = new ArrayList<>();
    private final static List<MainListModel> sandwichesList = new ArrayList<>();
    private final static List<MainListModel> mainDishList = new ArrayList<>();
    private final static List<MainListModel> easyRecList = new ArrayList<>();
    private final static List<MainListModel> mediumRecList = new ArrayList<>();
    private final static List<MainListModel> hardRecList = new ArrayList<>();
    private final static List<MainListModel> ingredientList = new ArrayList<>();
    private final static List<MainListModel> temp = new ArrayList<>();
    private final static List<String> categories = new ArrayList<>();



    public static List<String> getCategories(){
        if(categories.isEmpty()){
        categories.add("Main Dishes");
        categories.add("Salads");
        categories.add("Sandwiches");
        categories.add("Snacks");
        categories.add("Desserts");
        }else
            return categories;

        return categories;
    }


    public static List<MainListModel> getDesertList() {
        if(desertList.isEmpty()) {
            desertList.add(new MainListModel("تيراميسو", "متوسط", "ساعة", "one , اثنان", null, null));
            desertList.add(new MainListModel("تيراميسوة", "متوسط", "ساعة", "واحد \n اثنان", null, null));
            desertList.add(new MainListModel("تيراميسو", "سهل", "ساعة", "واحد \n اثنان", null, null));
        }else
            return desertList;

        return desertList;
    }


    public static List<MainListModel> getSaladList() {

        if(saladList.isEmpty()) {
            saladList.add(new MainListModel("خس", "متوسط", "ساعة", "one , اثنان", null, null));
            saladList.add(new MainListModel("طماطم", "متوسط", "ساعة", "واحد \n اثنان", null, null));
            saladList.add(new MainListModel("خيار", "سهل", "ساعة", "واحد \n اثنان", null, null));
        }else
            return saladList;

        return saladList;
    }

    public  List<MainListModel> getSandwichesList() {
        return sandwichesList;
    }



    public  List<MainListModel> getMainDishList() {
        return mainDishList;
    }


    public static List<MainListModel> getMainList() {

        mainList.add(new MainListModel("خس", "متوسط", "ساعة", "one , اثنان", null, null));
        mainList.add(new MainListModel("طماطم", "متوسط", "ساعة", "واحد \n اثنان", null, null));
        mainList.add(new MainListModel("خيار", "سهل", "ساعة", "واحد \n اثنان", null, null));
        mainList.add(new MainListModel("تيراميسو", "متوسط", "ساعة", "one , اثنان", null, null));
        mainList.add(new MainListModel("تيراميسوة", "متوسط", "ساعة", "واحد \n اثنان", null, null));
        mainList.add(new MainListModel("تيراميسو", "سهل", "ساعة", "واحد \n اثنان", null, null));

        return mainList;
    }




    public  List<MainListModel> getEasyRecList(String listName){
        easyRecList.clear();

        if(listName.toLowerCase().equals("salad")){
            temp.clear();
            temp.addAll(getSaladList());
        }else if(listName.equals("desert")){
            temp.clear();
            temp.addAll(getDesertList());
        }else if(listName.equals("main")){
            temp.clear();
            temp.addAll(getMainList());
        }else if(listName.equals("maindish")){
            temp.clear();
            temp.addAll(getMainDishList());
        }


        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getDifficultyLevel().equals("سهل")){

                easyRecList.add(temp.get(i));}
            }


        return easyRecList;
    }

    public  List<MainListModel> getMediumRecList(String listName) {

        mediumRecList.clear();
        if(listName.toLowerCase().equals("salad")){
            temp.clear();
            temp.addAll(getSaladList());
        }else if(listName.equals("desert")){
            temp.clear();
            temp.addAll(getDesertList());
        }else if(listName.equals("main")){
            temp.clear();
            temp.addAll(getMainList());
        }else if(listName.equals("maindish")){
            temp.clear();
            temp.addAll(getMainDishList());
        }



            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getDifficultyLevel().equals("متوسط")) {

                    mediumRecList.add(temp.get(i));
                }



        }
        return mediumRecList;
    }

    public  List<MainListModel> getHardRecList(String listName) {
            hardRecList.clear();
        if(listName.toLowerCase().equals("salad")){
            temp.clear();
            temp.addAll(getSaladList());
        }else if(listName.equals("desert")){
            temp.clear();
            temp.addAll(getDesertList());
        }else if(listName.equals("main")){
            temp.clear();
            temp.addAll(getMainList());
        }else if(listName.equals("maindish")){
            temp.clear();
            temp.addAll(getMainDishList());
        }

        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i).getDifficultyLevel().equals("صعب")){

                hardRecList.add(temp.get(i));}
            }


        return hardRecList;
    }


    public   List<MainListModel> getIngredientList(String ingredients, String listName) {


        if(listName.toLowerCase().equals("salad")){
            temp.clear();
            temp.addAll(getSaladList());
        }else if(listName.equals("desert")){
            temp.clear();
            temp.addAll(getDesertList());
        }else if(listName.equals("main")){
            temp.clear();
            temp.addAll(getMainList());
        }else if(listName.equals("maindish")){
            temp.clear();
            temp.addAll(getMainDishList());
        }

        for(int i = 0; i < temp.size(); i++){

            if(temp.get(i).getIngredients().contains(ingredients)){

                ingredientList.add(temp.get(i));}

        }


        return ingredientList;
    }
}
