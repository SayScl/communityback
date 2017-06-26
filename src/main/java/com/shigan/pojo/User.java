package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/26.
 */
public class User {

    private Integer id ;
    private String phone_number;
    private String nickname;
    private String name;
    private String city;
    private String community;
    private String address;
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCommunity() {
        return community;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
