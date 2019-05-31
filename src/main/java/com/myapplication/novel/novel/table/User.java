package com.myapplication.novel.novel.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String relasename;

    private String nickname;

    private String account;

    private String password;

    private String icon;

    private Integer likestarts;

    private Integer fances;

    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelasename() {
        return relasename;
    }

    public void setRelasename(String relasename) {
        this.relasename = relasename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLikestarts() {
        return likestarts;
    }

    public void setLikestarts(Integer likestarts) {
        this.likestarts = likestarts;
    }

    public Integer getFances() {
        return fances;
    }

    public void setFances(Integer fances) {
        this.fances = fances;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", relasename='" + relasename + '\'' +
                ", nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", likeStarts=" + likestarts +
                ", fances=" + fances +
                ", token='" + token + '\'' +
                '}';
    }
}
