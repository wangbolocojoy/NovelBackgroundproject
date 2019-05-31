package com.myapplication.novel.novel.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
@JsonIgnoreProperties(value =  {"handler","hibernateLazyInitializer","fieldHandler"})
public class MyImages {
    @Id
    @GeneratedValue
    private Integer Id;

    private String ImageUrl;

    private String ImageKey;

    private String ImageName;

    private String ImageMsg;


    public MyImages() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageKey() {
        return ImageKey;
    }

    public void setImageKey(String imageKey) {
        ImageKey = imageKey;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageMsg() {
        return ImageMsg;
    }

    public void setImageMsg(String imageMsg) {
        ImageMsg = imageMsg;
    }

    @Override
    public String toString() {
        return "MyImages{" +
                "Id=" + Id +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", ImageKey='" + ImageKey + '\'' +
                ", ImageName='" + ImageName + '\'' +
                ", ImageMsg='" + ImageMsg + '\'' +
                '}';
    }
}
