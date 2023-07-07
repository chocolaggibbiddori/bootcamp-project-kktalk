package com.kokoa.domain;

public abstract class Profile {

    private final String id;
    private final String name;
    private final String img_url;

    public Profile(String id, String name, String img_url) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg_url() {
        return img_url;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
