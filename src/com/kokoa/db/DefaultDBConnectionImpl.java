package com.kokoa.db;

import com.kokoa.domain.UserInfo;
import com.kokoa.dto.ProfileDto;
import com.kokoa.dto.ProfileTagsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kokoa.util.DBConnectionUtil.close;
import static com.kokoa.util.DBConnectionUtil.getConnection;

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
            return isValidUser(userInfo, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        } finally {
            close(con, pstmt, rs);
        }
    }

    private boolean isValidUser(UserInfo userInfo, ResultSet rs) throws SQLException {
        return rs.next() && isCorrectPassword(userInfo, rs);
    }

    private boolean isCorrectPassword(UserInfo userInfo, ResultSet rs) throws SQLException {
        return rs.getString("password").equals(userInfo.getPassword());
    }

    @Override
    public List<ProfileDto> getFriends(UserInfo userInfo) {
        Connection con = getConnection();
        String query = "select friend_id from friend where my_id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<ProfileDto> friends = new ArrayList<>();
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

    private ProfileDto getProfileById(Connection con, String id) {
        String query = "select name, img_url from profile where id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String img_url = rs.getString("img_url");
                return new ProfileDto(id, name, img_url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        } finally {
            close(null, pstmt, rs);
        }

        return null;
    }

    public ProfileTagsDto getProfileById(String id) {
        Connection con = getConnection();
        String query = "select name, img_url, profile_message from profile where id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String img = rs.getString("img_url");
                String message = rs.getString("profile_message");
                return new ProfileTagsDto(img, name, message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        } finally {
            close(con, pstmt, rs);
        }

        return null;
    }
}
