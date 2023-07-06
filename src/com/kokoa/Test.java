package com.kokoa;

import com.kokoa.controller.Controller;
import com.kokoa.db.DBConnectionUtil;
import com.kokoa.domain.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws SQLException {
        dropAllTable();
        createAllTable();
        insertData();
        Controller controller = Controller.getInstance();
        controller.login(new UserInfo("didrkd684", "tkfkdgo486"));
    }

    static void dropAllTable() throws SQLException {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        stmt.execute("drop table if exists login");
        stmt.execute("drop table if exists profile");
        stmt.execute("drop table if exists friend");
    }

    static void createAllTable() throws SQLException {
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

    static void insertData() throws SQLException {
        Connection con = DBConnectionUtil.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into login values('didrkd684', 'tkfkdgo486')");
        stmt.executeUpdate("insert into profile values('didrkd684', '강동희', '***', 'dev')");
        stmt.executeUpdate("insert into profile values('javaMachine', '김자바', '&&&', 'user')");
        stmt.executeUpdate("insert into friend values('didrkd684', 'javaMachine')");
    }
}
