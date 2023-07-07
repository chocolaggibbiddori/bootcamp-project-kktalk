package com.kokoa.dto;

public class ProfileTagsDto {

    private final String img;
    private final String name;
    private final String message;

    public ProfileTagsDto(String img, String name, String message) {
        this.img = img;
        this.name = name;
        this.message = message;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
