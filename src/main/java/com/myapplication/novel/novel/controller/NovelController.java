package com.myapplication.novel.novel.controller;

import com.myapplication.novel.novel.annotation.UserLoginToken;
import com.myapplication.novel.novel.basebean.BaseResult;
import com.myapplication.novel.novel.basebean.HttpCode;
import com.myapplication.novel.novel.repository.NovelRespository;
import com.myapplication.novel.novel.repository.NovelTypeRespository;
import com.myapplication.novel.novel.table.Novel;
import com.myapplication.novel.novel.untils.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/mynovel")
public class NovelController {
    public Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NovelRespository novelRespository;
    @Autowired
    private NovelTypeRespository novelTypeRespository;

    /**
     * 获取小说列表
     *
     * @param response
     * @param page
     * @param size
     * @param type
     * @throws Exception
     */
//    @UserLoginToken
    @RequestMapping(value = "/pagenovel")
    public void getpageNovel(HttpServletResponse response, @RequestParam(name = "page", defaultValue = "0") Integer page,
                             @RequestParam(name = "size", defaultValue = "10") Integer size
            , @RequestParam(name = "type", defaultValue = "8") Integer type) throws Exception {
        if (type >= 8) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Novel> pages = novelRespository.findAll(pageable);
            Iterator<Novel> iterator = pages.iterator();
            JsonHelper.toJson(new BaseResult(HttpCode.successcode, HttpCode.successmsg, iterator), response);
        } else {
            Pageable pageable = PageRequest.of(page, size);
            Page<Novel> pages = novelRespository.findAllByNovel_type(type, pageable);
            Iterator<Novel> iterator = pages.iterator();
            JsonHelper.toJson(new BaseResult(HttpCode.successcode, HttpCode.successmsg, iterator), response);

        }
    }
    /**
     * 搜索小说
     *
     * @param response
     * @param novelname
     * @throws Exception
     */
//    @UserLoginToken
    @RequestMapping(value = "/searchnovel")
    public void searchNovel(HttpServletResponse response, @RequestParam(name = "novelname", defaultValue = "") String novelname) throws Exception {
        log.info("novelname=" + novelname);
        if (novelname.isEmpty()) {
            JsonHelper.toJson(new BaseResult(HttpCode.notdatacode, HttpCode.notdatamsg, "参数为空,请输入你要搜索的书籍"), response);
            return;
        }
        List<Novel> list;
        list = novelRespository.findByNovel_nameLike(novelname);
        if (null != list) {
            JsonHelper.toJson(new BaseResult(HttpCode.successcode, HttpCode.successmsg, list), response);
        } else {
            JsonHelper.toJson(new BaseResult(HttpCode.notdatacode, HttpCode.notdatamsg, null), response);
        }
    }
    /**
     * 获取小说类别
     *
     * @param response
     * @throws Exception
     */
//    @UserLoginToken
    @RequestMapping(value = "/getallnoveltype")
    public void getallnoveltype(HttpServletResponse response) throws Exception {
        List list = novelTypeRespository.findAll();
        System.out.println("list" + list.toString());
        if (!list.isEmpty()) {
            JsonHelper.toJson(new BaseResult(HttpCode.successcode, HttpCode.successmsg, list), response);
        } else {
            JsonHelper.toJson(new BaseResult(HttpCode.notdatacode, HttpCode.notdatamsg, null), response);
        }

    }


}
