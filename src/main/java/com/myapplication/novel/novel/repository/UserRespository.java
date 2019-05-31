package com.myapplication.novel.novel.repository;

import com.myapplication.novel.novel.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRespository extends JpaRepository<User,Long> {
//    @Query("select st from User st where st.Account=:account")
    User findByAccount(@Param("account")String account);
}
