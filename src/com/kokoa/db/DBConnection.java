package com.kokoa.db;

import com.kokoa.domain.Profile;
import com.kokoa.domain.UserInfo;

import java.util.List;

public interface DBConnection {

    boolean authenticateUser(UserInfo userInfo);

    List<Profile> getFriends(UserInfo userInfo);
}
