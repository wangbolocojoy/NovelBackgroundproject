package com.myapplication.novel.novel.repository;

import com.myapplication.novel.novel.table.Novel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NovelRespository extends JpaRepository<Novel,String>,JpaSpecificationExecutor {


    //    Novel findbyNovelByNovel_id(Integer novel_id);
    @Query("select st from Novel st where st.novel_name like %?1%")
    List<Novel> findByNovel_nameLike(String name);
    @Query("select st from Novel st where st.novel_type=:novel_type")
    Page<Novel> findAllByNovel_type(@Param("novel_type") Integer type,Pageable pageable);


}
