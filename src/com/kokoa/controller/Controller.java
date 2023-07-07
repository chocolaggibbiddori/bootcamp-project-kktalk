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
        if (connection.authenticateUser(userInfo)) {
            System.out.println("로그인 성공!");
            makeFriendListHTML(userInfo);
        } else {
            System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다!");
        }
    }

    public void makeFriendListHTML(UserInfo userInfo) {
        List<Profile> friends = connection.getFriends(userInfo);
        FriendScreen.makeFriendScreenHTML(userInfo, friends);
    }
}
