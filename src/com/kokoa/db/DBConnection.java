package com.kokoa.db;

import com.kokoa.domain.UserInfo;
import com.kokoa.dto.ProfileDto;

import java.util.List;

public interface DBConnection {

    boolean authenticateUser(UserInfo userInfo);

    List<ProfileDto> getFriends(UserInfo userInfo);
}
