package com.example.comp421task3;

import java.util.Date;
import java.util.List;


class Item{
    public String id;
    public String todo;
    public String dis;
    public boolean isCheck;

    Item(String todo, String dis, boolean isCheck){
        this.id = new Date(System.currentTimeMillis()).toString();
        this.todo = todo;
        this.dis = dis;
        this.isCheck = isCheck;
    }

    public String getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public String getDis() {
        return dis;
    }

    public boolean isCheck() {
        return isCheck;
    }
}