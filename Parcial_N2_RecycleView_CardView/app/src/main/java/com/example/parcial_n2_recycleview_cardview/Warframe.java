package com.example.parcial_n2_recycleview_cardview;

public class Warframe {
    private String name, version, description;
    private int image;

    public Warframe(String name, String version, String description, int image) {
        this.name = name;
        this.version = version;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
