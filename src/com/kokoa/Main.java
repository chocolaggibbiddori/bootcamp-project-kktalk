package com.kokoa;

import com.kokoa.controller.Controller;
import com.kokoa.util.DBConnectionUtil;
import com.kokoa.domain.UserInfo;
import com.kokoa.console.Scan;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.kokoa.console.Print.*;

public class Main {
    public static void main(String[] args) {
        programInit();
        printStartMessage();

        Controller controller = Controller.getInstance();
        UserInfo userInfo = null;
        boolean run = true;
        while (run) {
            String id = Scan.getId();
            String password = Scan.getPassword();
            userInfo = new UserInfo(id, password);

            if (!controller.login(userInfo)) {
                printLoginFail();
            } else {
                run = false;
            }
        }

        controller.makeFriendListHTML(userInfo);
        printLoggingIn();
    }

    private static void programInit() {
        try {
            dbInit();
            dataInit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    private static void dbInit() throws SQLException {
        dropAllTable();
        createAllTable();
    }

    private static void dropAllTable() throws SQLException {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("drop table if exists login");
        stmt.execute("drop table if exists profile");
        stmt.execute("drop table if exists friend");
    }

    private static void createAllTable() throws SQLException {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("create table login(\n" + "id varchar(20) primary key,\n" + "password varchar(20) not null)");
        stmt.execute("create table profile(\n" + "id varchar(20) primary key,\n" + "name varchar(10) not null,\n" + "img_url varchar(100),\n" + "profile_message varchar(100))");
        stmt.execute("create table friend(\n" + "my_id varchar(20),\n" + "friend_id varchar(20))");
    }

    private static void dataInit() throws SQLException {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        initTableLogin(stmt);
        initTableProfile(stmt);
        initTableFriend(stmt);
    }

    private static void initTableLogin(Statement stmt) throws SQLException {
        stmt.executeUpdate("insert into login values('didrkd684', 'tkfkdgo486')");
        stmt.executeUpdate("insert into login values('kkh', '1234')");
    }

    private static void initTableProfile(Statement stmt) throws SQLException {
        stmt.executeUpdate("insert into profile values('didrkd684', '강동희', 'https://avatars.githubusercontent.com/u/85636077?s=48&v=4', 'Im kktalk_운영자')");
        stmt.executeUpdate("insert into profile values('pjw', '박정우', 'https://avatars.githubusercontent.com/u/90658158?s=48&v=4', 'Im kktalk_운영자')");
        stmt.executeUpdate("insert into profile values('nemotnwl', '수지', 'https://ca.slack-edge.com/T059HAPCRB2-U058M1LPDAA-9f608b337c67-512', '화이팅')");
        stmt.executeUpdate("insert into profile values('kkh', '강기훈', 'https://ca.slack-edge.com/T059HAPCRB2-U05AQ8S6GVA-g17b6d25e2df-72', '여기까지 이해가 되셨습니까')");
        stmt.executeUpdate("insert into profile values('mintimel', '박기철', 'https://ca.slack-edge.com/T059HAPCRB2-U059FL9AJQ6-55b1f1efc2ed-512', 'ㅎㅎㅎㅎ')");
    }

    private static void initTableFriend(Statement stmt) throws SQLException {
        stmt.executeUpdate("insert into friend values('didrkd684', 'pjw')");
        stmt.executeUpdate("insert into friend values('didrkd684', 'Amorvincit')");
        stmt.executeUpdate("insert into friend values('kkh', 'didrkd684')");
        stmt.executeUpdate("insert into friend values('kkh', 'pjw')");
        stmt.executeUpdate("insert into friend values('kkh', 'nemotnwl')");
        stmt.executeUpdate("insert into friend values('kkh', 'mintimel')");
    }
}
