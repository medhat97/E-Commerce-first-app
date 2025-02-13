package com.example.Ecommerce.model;

public class Store {
    private String id;
    private String name;
    private String location;
    private String manager;

    public Store(String id, String name, String location, String manager) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getManager() {
        return manager;
    }
}
