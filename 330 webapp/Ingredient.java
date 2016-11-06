package com.cs330;


public class Ingredient{

        private int ID;
        private String name;
        private String category;


    Ingredient(){
    
    }

    Ingredient(int ID, String name, String category){
    
    this.ID=ID;
    this.name=name;
    this.category=category;
    
    }

    Ingredient(String name,String category){
    
    this.name=name;
    this.category=category;
    this.ID=0;
    
    }
    
    
    
    public String getName(){
    
    return name;
    
    }
    
     public String getCategory(){
     
     
     return category;}
    
    public String toString(){
    
    return ID+":"+name+" ("+category+")";
    
    }


}