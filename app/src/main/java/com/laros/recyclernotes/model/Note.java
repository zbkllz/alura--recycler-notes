package com.laros.recyclernotes.model;

public class Note {
    private final String title;
    private final String description;

    public Note(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
}
