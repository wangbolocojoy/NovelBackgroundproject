package com.myapplication.novel.novel.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noveltype")
@JsonIgnoreProperties(value =  {"handler","hibernateLazyInitializer","fieldHandler"})
public class NovelType {

    @Id
    @GeneratedValue
    private Integer id;
    private String typename;
    private String typeimg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypeimg() {
        return typeimg;
    }

    public void setTypeimg(String typeimg) {
        this.typeimg = typeimg;
    }

    @Override
    public String toString() {
        return "NovelType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", typeimg='" + typeimg + '\'' +
                '}';
    }
}
