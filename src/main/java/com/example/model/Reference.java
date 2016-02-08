package com.example.model;

/**
 * Created by odzhara-ongom on 01.02.2016.
 */
public class Reference {
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reference(){}

    public Reference(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
