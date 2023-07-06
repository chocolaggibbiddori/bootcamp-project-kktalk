package com.kokoa.domain;

public abstract class Profile {

    private final String id;
    private final String name;
    private final String img_url;
    private final String profile_message;

    public Profile(String id, String name, String img_url, String profile_message) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.profile_message = profile_message;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", profile_message='" + profile_message + '\'' +
                '}';
    }
}
