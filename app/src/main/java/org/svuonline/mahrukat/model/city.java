package org.svuonline.mahrukat.model;

public class city {
    private int id;
    private String name;

    public city() {

    }

    public city(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
