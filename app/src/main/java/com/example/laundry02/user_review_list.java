package com.example.laundry02;

public class user_review_list {
    public String user_id;
    public int score;
    public String content;

    user_review_list(String user_id, int score, String content){
        this.user_id = user_id;
        this.score = score;
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }
    public int getScore(){ return score;}
    public String getContent(){
        return content;
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
