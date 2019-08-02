package com.bosch.mapper;

import com.bosch.autho.UserPermission;
import com.bosch.vo.UserVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userMapper")
public interface UserMapper {

    @Results({
            @Result(property = "userId", column = "ID"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "password", column = "PASSWORD")
    })
    @Select("SELECT * FROM USER WHERE USERNAME = #{username};")
    List<UserVO> queryByUsername(String username);

    @Update("UPDATE USER SET PASSWORD = #{newPwd} WHERE USERNAME = #{username};")
    int updatePassword(String username, String newPwd);

    @Update("UPDATE USER SET LAST_LOGIN = NOW() WHERE USERNAME = #{username};")
    int updateLastLogin(String username);

    List<UserPermission> queryPermissionList(String username);
}
