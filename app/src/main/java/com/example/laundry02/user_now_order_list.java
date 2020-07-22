package com.example.laundry02;

public class user_now_order_list {
    public String s_name;
    public String date;

    user_now_order_list(String s_name, String date){
        this.s_name =s_name;
        this.date = date;
    }

    public String getS_name() {
        return s_name;
    }
    public String getDate(){
        return date;
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
