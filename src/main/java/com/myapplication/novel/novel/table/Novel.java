package com.myapplication.novel.novel.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "novel")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Novel implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer novel_id;
    private String novel_name;
    private String novel_easyinfo;
    private String novel_author;
    private String novel_img;
    private Integer novel_type;
    private String novel_typename;
    private String novel_uptime;
    private String novel_state;


    public Novel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(Integer novel_id) {
        this.novel_id = novel_id;
    }

    public String getNovel_name() {
        return novel_name;
    }

    public void setNovel_name(String novel_name) {
        this.novel_name = novel_name;
    }

    public String getNovel_easyinfo() {
        return novel_easyinfo;
    }

    public void setNovel_easyinfo(String novel_easyinfo) {
        this.novel_easyinfo = novel_easyinfo;
    }

    public String getNovel_author() {
        return novel_author;
    }

    public void setNovel_author(String novel_author) {
        this.novel_author = novel_author;
    }

    public String getNovel_img() {
        return novel_img;
    }

    public void setNovel_img(String novel_img) {
        this.novel_img = novel_img;
    }

    public Integer getNovel_type() {
        return novel_type;
    }

    public void setNovel_type(Integer novel_type) {
        this.novel_type = novel_type;
    }

    public String getNovel_typename() {
        return novel_typename;
    }

    public void setNovel_typename(String novel_typename) {
        this.novel_typename = novel_typename;
    }

    public String getNovel_uptime() {
        return novel_uptime;
    }

    public void setNovel_uptime(String novel_uptime) {
        this.novel_uptime = novel_uptime;
    }

    public String getNovel_state() {
        return novel_state;
    }

    public void setNovel_state(String novel_state) {
        this.novel_state = novel_state;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id=" + id +
                ", novel_id=" + novel_id +
                ", novel_name='" + novel_name + '\'' +
                ", novel_easyinfo='" + novel_easyinfo + '\'' +
                ", novel_author='" + novel_author + '\'' +
                ", novel_img='" + novel_img + '\'' +
                ", novel_type=" + novel_type +
                ", novel_typename='" + novel_typename + '\'' +
                ", novel_uptime='" + novel_uptime + '\'' +
                ", novel_state='" + novel_state + '\'' +
                '}';
    }
}
