package com.example.laundry02;

public class user_itempage_list {
    public String item_name;
    public String price;

    user_itempage_list(String item_name, String price){
        this.item_name =item_name;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }
    public String getPrice(){
        return price;
    }

}

/*
public class Human {
    public String name;
    public String gender;
    public String age;
    public int image;

    public String getName() {
        return name;
    }
    public String getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public int getImage(){
        return image;
    }

    Human(String name, String gender, String age, int image){
        this.image = image;
        this.name =name;
        this.gender = gender;
        this.age = age;
    }


}*/
