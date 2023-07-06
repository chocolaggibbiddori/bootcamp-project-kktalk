package com.kokoa;

import com.kokoa.controller.Controller;
import com.kokoa.db.DBConnectionUtil;
import com.kokoa.domain.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    private static final Controller controller = Controller.getInstance();

    public static void main(String[] args) throws SQLException {
        testInit();
        insertData();
        controller.login(new UserInfo("didrkd684", "tkfkdgo486"));
        controller.login(new UserInfo("chocola", "1234"));
    }

    private static void testInit() throws SQLException {
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
        stmt.execute("create table login(\n" +
                "id varchar(20) primary key,\n" +
                "password varchar(20) not null)");

        stmt.execute("create table profile(\n" +
                "id varchar(20) primary key,\n" +
                "name varchar(10) not null,\n" +
                "img_url varchar(100),\n" +
                "profile_message varchar(100))");
        stmt.execute("create table friend(\n" +
                "my_id varchar(20),\n" +
                "friend_id varchar(20))");
    }

    private static void insertData() throws SQLException {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into login values('didrkd684', 'tkfkdgo486')");
        stmt.executeUpdate("insert into profile values('didrkd684', '강동희', '***', 'dev')");
        stmt.executeUpdate("insert into profile values('javaMachine', '김자바', '&&&', 'user')");
        stmt.executeUpdate("insert into friend values('didrkd684', 'javaMachine')");
    }
}
