package com.kokoa.db;

import com.kokoa.domain.FriendProfile;
import com.kokoa.domain.Profile;
import com.kokoa.domain.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kokoa.db.DBConnectionUtil.close;
import static com.kokoa.db.DBConnectionUtil.getConnection;

public class DefaultDBConnectionImpl implements DBConnection {

    @Override
    public boolean authenticateUser(UserInfo userInfo) {
        Connection con = getConnection();
        String query = "select password from login where id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userInfo.getId());
            rs = pstmt.executeQuery();

            if (isValidUser(userInfo, rs)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        } finally {
            close(con, pstmt, rs);
        }

        System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다!");
        return false;
    }

    private boolean isValidUser(UserInfo userInfo, ResultSet rs) throws SQLException {
        return rs.next() && isCorrectPassword(userInfo, rs);
    }

    private boolean isCorrectPassword(UserInfo userInfo, ResultSet rs) throws SQLException {
        return rs.getString("password").equals(userInfo.getPassword());
    }

    @Override
    public List<Profile> getFriends(UserInfo userInfo) {
        Connection con = getConnection();
        String query = "select friend_id from friend where my_id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Profile> friends = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userInfo.getId());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String friendId = rs.getString("friend_id");
                friends.add(getProfileById(con, friendId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        } finally {
            close(con, pstmt, rs);
        }

        return friends;
    }

    private Profile getProfileById(Connection con, String id) {
        String query = "select name, img_url, profile_message from profile where id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String img_url = rs.getString("img_url");
                String profile_message = rs.getString("profile_message");
                return new FriendProfile(id, name, img_url, profile_message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        } finally {
            close(null, pstmt, rs);
        }

        return null;
    }
}
