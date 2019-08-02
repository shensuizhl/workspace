package com.bosch.vo;

/**
 * @program: demo
 * @description: VO for User
 * @author: wjy
 * @create: 2019-06-8 17:36
 */
public class UserVO {

    private int userId;
    private String username;
    private String password;

    public UserVO(){

    }

    public UserVO(UserVO userVO){
        this.userId = userVO.userId;
        this.username = userVO.username;
        this.password = userVO.password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
