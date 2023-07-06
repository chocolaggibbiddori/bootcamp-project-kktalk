package com.kokoa.controller;

import com.kokoa.db.DBConnection;
import com.kokoa.db.DefaultDBConnectionImpl;
import com.kokoa.domain.Profile;
import com.kokoa.domain.UserInfo;
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

    public void login(UserInfo userInfo) {
        if(connection.authenticateUser(userInfo)) {
            makeFriendListHTML(userInfo);
        }

        // TODO: 2023/07/05 실패 시 오류 페이지 만들기(선택)
    }

    public void makeFriendListHTML(UserInfo userInfo) {
        List<Profile> friends = connection.getFriends(userInfo);
        FriendScreen.makeFriendScreenHTML(userInfo, friends);
    }
}
