package org.bcos.browser.mapper;

import org.apache.ibatis.annotations.Param;
import org.bcos.browser.entity.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void addUser(User user);

    User getUserById(@Param("userId") String userId);
}
