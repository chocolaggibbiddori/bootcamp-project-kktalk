package com.kokoa.dto;

public class ProfileDto {

    private final String id;
    private final String name;
    private final String img;

    public ProfileDto(String id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "ProfileDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
