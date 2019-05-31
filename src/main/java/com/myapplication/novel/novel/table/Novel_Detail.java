package com.myapplication.novel.novel.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "novel_detail")
@JsonIgnoreProperties(value =  {"handler","hibernateLazyInitializer","fieldHandler"})
public class Novel_Detail implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer novel_id;
    private String novel_content;
    private String novel_chapter;

    public Novel_Detail() {
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

    public String getNovel_content() {
        return novel_content;
    }

    public void setNovel_content(String novel_content) {
        this.novel_content = novel_content;
    }

    public String getNovel_chapter() {
        return novel_chapter;
    }

    public void setNovel_chapter(String novel_chapter) {
        this.novel_chapter = novel_chapter;
    }

    @Override
    public String toString() {
        return "Novel_Detail{" +
                "id=" + id +
                ", novel_id=" + novel_id +
                ", novel_content='" + novel_content + '\'' +
                ", novel_chapter='" + novel_chapter + '\'' +
                '}';
    }
}
