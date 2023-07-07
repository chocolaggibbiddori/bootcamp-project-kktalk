package com.kokoa.domain;

public class MyProfile extends Profile {

    private final String profile_message;

    public MyProfile(String id, String name, String img_url, String profile_message) {
        super(id, name, img_url);
        this.profile_message = profile_message;
    }
}
