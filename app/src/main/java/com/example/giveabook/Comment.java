package com.example.giveabook;

public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;

    public void Comment(int postId,int id, String name, String email){
        this.email=email;
        this.id=id;
        this.name=name;
        this.postId=postId;
    }
}
