package com.system.restaurant.controller;

import java.sql.Date;
import java.sql.Timestamp;

public class Board {
    private int id;
    private String title;
    private String content;
    private Timestamp regDate;

    public Board() {}

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reg_date=" + regDate +
                '}';
    }
}
