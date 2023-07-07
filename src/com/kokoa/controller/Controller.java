package com.kokoa.controller;

import com.kokoa.db.DBConnection;
import com.kokoa.db.DefaultDBConnectionImpl;
import com.kokoa.domain.UserInfo;
import com.kokoa.dto.ProfileDto;
import com.kokoa.html.FriendScreen;

import java.util.List;

public class Controller {

    private static final Controller INSTANCE = new Controller();

    private final DBConnection connection;

    private Controller() {
        connection = new DefaultDBConnectionImpl(); // 구체 클래스 변경
    }

    public static Controller getInstance() {
        return INSTANCE;
    }

    public boolean login(UserInfo userInfo) {
        return connection.authenticateUser(userInfo);
    }

    public void makeFriendListHTML(UserInfo userInfo) {
        List<ProfileDto> friends = connection.getFriends(userInfo);
        FriendScreen.makeFriendScreenHTML(userInfo, friends);
    }
}
